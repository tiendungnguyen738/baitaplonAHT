$(document).ready(function(){
	
	var pass = "";
	
	$("#userPass").keyup(function(){
		pass = $(this).val();
	})
	
	$("#nhaplaimatkhau").keyup(function(){
		if($(this).val() != pass){
			$("#error").html("ko khớp");
			$("#error").css("color","red");
			$("#submit").prop("disabled","true");
		}
		else{
			$("#error").html("");
			$("#submit").removeAttr("disabled");
		}
	})
	
	$("body").on("click","#check",function(){	
		if(true == $(this).prop("checked")){
			$("#userPass").removeAttr("readonly");
			$("#nhaplaimatkhau").removeAttr("readonly");
		}
		else if(false == $(this).prop("checked")){
			$("#userPass").prop("readonly","true");
			$("#nhaplaimatkhau").prop("readonly","true");
		}
	})
})