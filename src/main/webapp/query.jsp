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
p {
	
}

</style>

</head>

<body>
	<div class="div2">
		<center><h2>数据查询</h2></center>
		<hr><br>
		<form action="query" method="POST" class="div2-form">
			<div style="margin-left:35%">
					请选择类型&nbsp;&nbsp;&nbsp;&nbsp;:       
					<input type="radio" value="no" name="1" checked="checked" /> 编号 
					<input type="radio" value="name" name="1" /> 书名 
					<br /> <br /> 
					请输入关键字&nbsp;: <input type="text" name="value" />
					<br> <br /> 
					<input type="submit" value="Submit" style="margin-left: 70px ; margin-right: 29px" /> 
					<input type="reset" value="Reset" />
			</div>
		</form>
	</div>
</body>

</html>