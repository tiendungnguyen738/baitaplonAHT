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
	
	
})