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
</style>

</head>

<body>
	<center>
	<div>
		<h2>数据插入</h2>
		<hr>
		
		<form action="insert" method="POST" class="div1-form">
			<div>
				<p>图书编号: <input type="text" name="no" /></p>
				<p>图书名称: <input type="text" name="name" /></p>
				<p>进购数量: <input type="text" name="total" /></p>
				<p>库房余数: <input type="text" name="left" /> </p>
			</div>
			<div>
				<input type="submit" value="SUBMIT" style="margin-left: 40px; margin-right: 20px" /> 
				<input type="reset" value= " RESET " />
			</div>
		</form>
	</div>
	</center>
</body>

</html>