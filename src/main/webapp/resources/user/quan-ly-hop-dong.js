$(document).ready(function(){
	

	$("body").on("click","#allBox",function(){	
		if(true == $(this).prop("checked")){
			$("#bang-hop-dong input[name='checkbox-id']").each(function(){
				 $(this).prop("checked", true );
			})
		}
		
		if(false == $(this).prop("checked")){
			$("#bang-hop-dong input[name='checkbox-id']").each(function(){
				 $(this).prop("checked", false );
			})
		}
		
	})
	

	$("body").on("click","#button-xoa",function(){
		var result = confirm("Bạn có chắc muốn xóa ??");
		if (result) {
			var id;
			$("#bang-hop-dong input[name='checkbox-id']:checked").each(function(){
				id = $(this).val();
				$(this).closest("tr").remove();
				$.ajax({
					url:"/aht/api-contract/xoa-hop-dong",
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
	

	$("#btn-them-hop-dong").click(function(){
		var mahopdong = $("#ma-hop-dong").val();
		$("#ma-hop-dong").val('');
		
		var loaihopdong = $("#loai-hop-dong").val();
		$("#loai-hop-dong").val('');
		
		$.ajax({
			url:"/aht/api-contract/them-hop-dong",
			type:"POST",
			data:{
				mahopdong:mahopdong,
				loaihopdong:loaihopdong
			},
			success:function(value){
				alert("bạn vừa thêm 1 hợp đồng");
			}
		})
	})
	
	/*lấy thông tin  để sửa*/
	$("body").on("click","#sua-hop-dong",function(){
		var id = $(this).val();
		
		$.ajax({
			url:"/aht/api-contract/lay-thong-tin-hop-dong",
			type:"POST",
			data:{
				id:id
			},
			success:function(value){
				$("#ma-hop-dong").val(value.contractCode);
				$("#loai-hop-dong").val(value.contractType);
				/*gán giá trị id  cần cập nhật cho nút cập nhật*/
				$("#cap-nhat-hop-dong").val(value.id);
				console.log(value);
			}			
		})
	})
	
	/*cập nhật thông tin*/
	$("#cap-nhat-hop-dong").click(function(){
		var mahopdong = $("#ma-hop-dong").val();
		var loaihopdong = $("#loai-hop-dong").val();
		var id = $(this).val();
		$("#bang-hop-dong input[name='checkbox-id']").each(function(){
			if($(this).val() == id){
				$(this).closest("tr").find("#ma-hd").text(mahopdong);
				$(this).closest("tr").find("#loai-hd").text(loaihopdong);
			}
		})  
		$.ajax({
			url:"/aht/api-contract/cap-nhat-hop-dong",
			type:"POST",
			data:{
				mahopdong:mahopdong,
				id:id,
				loaihopdong:loaihopdong
			},
			success:function(value){
				alert("cập nhật thông tin thành công");
				$("#ma-hop-dong").val('');
				$("#loai-hop-dong").val('');
			}
		})
	})
});