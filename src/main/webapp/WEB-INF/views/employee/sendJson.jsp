<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ajax JSON 데이터 전송</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function() {
	$("button").click(function(event){
		var user = {id:"bangry", name:"김기정", passwd:"1234"};
		// Object -> JSON String으로 변환
		var userString = JSON.stringify(user);
		alert(userString);

		$.ajax({
			url : "json6",
			method: "post",
			dataType: "json",
			data: userString,
			contentType: "application/json",
			success : function(object) {
				alert(object.name);
				setData(object);
			}
		});
		
		return false;
	});
	
	function setData(user){
		var userInfo = "";
		userInfo += "<h2>"+user.id+"</h2>";
		userInfo += "<h2>"+user.passwd+"</h2>";
		userInfo += "<h2>"+user.name+"</h2>";
		
		$("#message").html(userInfo);	
		//$("").apppendTo();
	}
});
</script>
</head>
<body>
	<button>JSON 데이터 전송</button>
	<div id="message"></div>
</body>
</html>