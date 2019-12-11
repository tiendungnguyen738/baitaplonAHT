$(document).ready(function(){
	
	$("body").on("click","#idUseridRole",function(){
		
		var idUser = $(this).closest("tr").find("#id").text();
		var idRole = $(this).closest("tr").find("option:selected").val();
		if(idRole==""){
			alert("chua chon quyen");
		}
		else{
			$(this).closest("tr").remove();
			$.ajax({
				url:'/aht/quan-tri/trang-chu/user-role/them-user-role/them',
				type:'get',
				data:{
					idUser:idUser,
					idRole:idRole
				},success:function(value){
					alert("them thanh cong");
				}
			});
		}
	})
	
	$("body").on("click","#update-quyen",function(){
		$(this).closest("tr").find(".sua-quyen").find(".roleList").css("display","inline");
		$(this).closest("tr").find(".sua-quyen").find("p").css("display","none");

		$(this).closest("td").find("#cancel").css("display","inline");
		$(this).closest("td").find("#update").css("display","inline");
		$(this).css("display","none");
	})
	
	$("body").on("click","#cancel",function(){
		$(this).closest("tr").find(".sua-quyen").find(".roleList").css("display","none");
		$(this).closest("tr").find(".sua-quyen").find("p").css("display","inline");
		$(this).closest("td").find("#update-quyen").css("display","inline");
		$(this).css("display","none");
		$(this).closest("td").find("#update").css("display","none");
	})
	
	$("body").on("click","#update",function(){
		var idUserRole = $(this).closest("tr").find("#idUserRole").attr("data-idUserRole");
		var idUser = $(this).closest("tr").find("#idUser").attr("data-idUser");
		var idRole = $(this).closest("tr").find("option:selected").val();
		
		$.ajax({
			url:"/aht/quan-tri/trang-chu/user-role/them-user-role/sua",
			type:"post",
			data:{
				idUserRole:idUserRole,
				idUser:idUser,
				idRole:idRole
			},success:function(value){
				alert("cap nhat thanh cong");
			}
		})
	})
})