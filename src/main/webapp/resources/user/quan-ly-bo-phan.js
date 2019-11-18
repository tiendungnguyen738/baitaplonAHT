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
	
	/*xóa bộ phận*/
	$("body").on("click","#button-xoa",function(){
		var result = confirm("Bạn có chắc muốn xóa ??");
		if (result) {
			var id;
			$("#bang-bo-phan input[name='checkbox-id']:checked").each(function(){
				id = $(this).val();
				$(this).closest("tr").remove();
				$.ajax({
					url:"/aht/api-parts/xoa-bo-phan",
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
	
	/*thêm bộ phận*/
	$("#btn-them-bo-phan").click(function(){
		var tenbophan = $("#ten-bo-phan").val();
		$("#ten-bo-phan").val('');
		$.ajax({
			url:"/aht/api-parts/them-bo-phan",
			type:"POST",
			data:{
				tenbophan:tenbophan
			},
			success:function(value){
				alert("bạn vừa thêm 1 bộ phận");
			}
		})
	})
	
	/*lấy thông tin bộ phận để sửa*/
	$("body").on("click","#sua-bo-phan",function(){
		var id = $(this).val();
		$.ajax({
			url:"/aht/api-parts/lay-thong-tin-bo-phan",
			type:"POST",
			data:{
				id:id
			},
			success:function(value){
				$("#ten-bo-phan").val(value.partsName);
				/*gán giá trị id của bộ phận cần cập nhật cho nút cập nhật*/
				$("#cap-nhat-bo-phan").val(value.id);
			}
		})
	})
	
	/*cập nhật thông tin bộ phận*/
	$("#cap-nhat-bo-phan").click(function(){
		var tenbophan = $("#ten-bo-phan").val();
		var id = $(this).val();
		$("#bang-bo-phan input[name='checkbox-id']").each(function(){
			if($(this).val() == id){
				$(this).closest("tr").find("#name-bp").text(tenbophan);
			}
		})  
		$.ajax({
			url:"/aht/api-parts/cap-nhat-bo-phan",
			type:"POST",
			data:{
				tenbophan:tenbophan,
				id:id
			},
			success:function(value){
				alert("cập nhật thông tin thành công");
			}
		})
	})
});