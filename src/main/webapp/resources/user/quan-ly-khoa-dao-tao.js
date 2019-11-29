$(document).ready(function() {
	
	// lấy danh sách nhân viên của từng phòng
	$("body").on("change", "#employeeDTO", function() {
		var id = $(this).val();		
		var tenphong = $("#employeeDTO option:selected").text();
		$.ajax({
			url:"/aht/trang-user/quan-ly-training-emp/danh-sach-nhan-vien",
			type:"get",
			data:{
				id:id
			},
			success:function(value){
				$("#danh-sach-nv tbody").html("");
				for(i in value){
					$("#danh-sach-nv tbody").append('<tr>'
							+'<td>'+value[i].id+'</td>'
							+'<td id="ten-phong">'+value[i].empName+'</td>'
							+'<td><button type="submit" id="them-khoa-dao-tao" class="btn btn-success" style="margin-left: 21%;'
							+'border-radius: 19%;"'
							+'data-value='+value[i].id
							+'>THÊM</button></td>'
						+'</tr>'		
					)
				}
				$("#phong").html("");
				$("#phong").html("Danh Sách Nhân Viên Phòng:"+tenphong);
			}
		})
	})
	
	$("body").on("click","#them-khoa-dao-tao",function(){
		employeeId = $(this).attr("data-value")
		trainingEmpDTO={};
		employeeDTO = {};
		trainingDTO = {};
		var formKhoaDaoTao = $("#formKhoaDaoTao").serializeArray();
		
		$.each(formKhoaDaoTao,function(i,field){
			if(field.name=="trainingDTO"){
				trainingDTO["id"]=field.value;
			}
			else{
				trainingEmpDTO[field.name]=field.value;
			}
		})
		employeeDTO["id"]=employeeId;
		trainingEmpDTO["employeeDTO"]=employeeDTO;
		trainingEmpDTO["trainingDTO"]=trainingDTO;
		console.log(trainingEmpDTO);
		console.log(JSON.stringify(trainingEmpDTO))
		$.ajax({
			url:"/aht/quan-ly-training-emp/them",
			type:"post",
			ContentType:'application/json',
			dataType:'json',
			data:{
				trainingEmp:JSON.stringify(trainingEmpDTO)
			},
			success:function(value){
				alert("thêm thành công");
			}
		});
	})
	
	
	//chọn tất cả các trường:
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
	
	$('#khoadaotao > option').each(function() {
		if($("#khoadaotao").attr("data-value") === $(this).val()){
			$(this).attr("selected",true);
		}
	});
	
	$('#departmentDTO > option').each(function(){
		if($("#departmentDTO").attr("data-value") === $(this).val()){
			$(this).attr("selected",true);
		}
	});
	
	$('#trainingDTO > option').each(function(){
		if($("#trainingDTO.id").attr("value") === $(this).val()){
			$(this).attr("selected",true);
		}
	});
})