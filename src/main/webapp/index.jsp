<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First</title>

<style type="text/css">
body {
	background-color: #D1EEEE;
}

input {
	margin-top: 30px;
	margin-left: 10px;
}
</style>

</head>

<body>
	<center>
		<font
			style="margin-top: 10px; font-size: 30px; font-family: sans-serif;">欢迎来到图书管理系统</font>
		<div style="background-image: url(image/1.jpg); background-repeat: no-repeat; width: 90%; 
			height: 668px; background-position: center; margin-top: 20px;">
			<div style="width: 40%; height: 50px; color: #E0FFFF; padding-top: 100px;">
				<form action="login" method="Post">
					帐号: <input type="text" name="username"> <br /> 
					密码: <input type="password" name="password" /> <br/>
					<input style="margin-left: 55px;" type="submit" value="提交"> 
					<input style="margin-left: 60px;" type="reset" value="重置">
				</form>
			</div>
		</div>
	</center>
</body>

</html>