$(function(){
	
})

function doLogin(){
	try {
		$('#login').ajaxSubmit({
			target: '#login', 
			async : false,
			type: 'post', 
	        url: "/doLogin.jspx",
	        dataType : "json", 
			success : function(result) {
				if(result.success){
					alert(result.msg);
					top.location.href ='index.jspx';
				}else{
					alert(result.msg);
				}
			}
		});
	} catch (e) {
		alert(e);
	}
}