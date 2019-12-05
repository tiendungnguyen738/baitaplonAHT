$(document).ready(function(){
	
	/*chọn tất cả checkbox*/
	$("body").on("click","#allBox",function(){		
		if(true == $(this).prop("checked")){
			$("#bang-bo-phan input[name='checkbox-id']").each(function(){
				 $(this).prop("checked", true );
			})
		}		
		if(false == $(this).prop("checked")){
			$("#bang-bo-phan input[name='checkbox-id']").each(function(){
				 $(this).prop("checked", false );
			})
		}		
	})
	
	/*xóa phòng ban*/
	$("body").on("click","#button-xoa",function(){
		var result = confirm("Bạn có chắc muốn xóa ??");
		if (result) {
			var id;
			$("#bang-bo-phan input[name='checkbox-id']:checked").each(function(){
				id = $(this).val();
				$(this).closest("tr").remove();
				$.ajax({
					url:"/aht/api-department/xoa-phong-ban",
					type:"POST",
					data:{
						id:id
					},
					success:function(value){
						alert("xóa thành công");
					}
				});
			})  
		}
	})
	
	/*thêm phòng ban*/
	$("#btn-them-bo-phan").click(function(){
		var tenphong = $("#ten-phong-ban").val();
		$("#ten-phong-ban").val('');
		var idBoPhan = $("#dsBoPhan").children("option:selected").val();
		$.ajax({
			url:"/aht/api-department/them-phong-ban",
			type:"POST",
			data:{
				tenphong:tenphong,
				idBoPhan:idBoPhan
			},
			success:function(value){
				alert("bạn vừa thêm 1 phòng");
			}
		})
	})
	
	$("body").on("click","#sua-phong-ban",function(){
		var id = $(this).val();
		$.ajax({
			url:"/aht/api-department/lay-thong-tin-phong-ban",
			type:"GET",
			data:{
				id:id
			},
			success:function(value){
				$("#ten-phong-ban").val(value.departmentName);
				$("#dsBoPhan").val(value.partDTO.id);
				$("#cap-nhat-phong-ban").val(value.id);
			}
		})
	})
	
	/*cập nhật thông tin phòng ban*/
	$("#cap-nhat-phong-ban").click(function(){
		var formTT = $("#form-bo-phan").serializeArray();
		phongBanJson = {};
		$.each(formTT,function(i,field){
			phongBanJson[field.name] = field.value;
		})
		phongBanJson["id"] = $("#cap-nhat-phong-ban").val();
	
		var tenPhongBan = $("#ten-phong-ban").val();
		var tenBoPhan = $("#dsBoPhan option:selected").text();
		
		$("#bang-bo-phan tr").each(function(){
			if($(this).find("#checkbox-id").val() == $("#cap-nhat-phong-ban").val()){
				$(this).closest("tr").find("#name-pb").text(tenPhongBan);
				$(this).closest("tr").find("#name-bp").text(tenBoPhan);
			}
		})
		
		$.ajax({
			url:"/aht/api-department/cap-nhat-phong-ban",
			type:"POST",
			data:{
				phongBanJson:JSON.stringify(phongBanJson)
			},
			success:function(value){
				alert("cập nhật thành công :))");
			}
		})
	})
});