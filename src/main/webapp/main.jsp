<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>URL</title>
<link rel="stylesheet" type="text/css" href="class/main.css" />
<style type="text/css">
input {
	margin-top: 12px;
}

td {
	border: 1px solid #000;
}
</style>
</head>
<body class="body">
	<div class="div1">
		<font class="div1-p1">数据插入</font>
		<form action="insert" method="POST" class="div1-form">
			<div class="div1-div1">
				<p>url(*)</p>
				<p>域名</p>
				<p>描述:</p>
				<p>病毒名 :</p>
				<p>标志 :</p>
				<p></p>
			</div>
			<div class="div1-div2">
				<input type="text" name="url" /> <br /> <input type="text"
					name="domain" /> <br /> <input type="text" name="description" />
				<br /> <input type="text" name="virusname" /> <br /> true : <input
					type="radio" name="0" value="1" style="margin-right: 60px"
					checked="checked" /> false : <input type="radio" name="0"
					value="0" />
			</div>
			<div class="div1-div3">
				<input type="submit" value="Submit" style="margin-right: 50px" /> <input
					type="reset" value="Reset" />
			</div>
			<div class="div1-div4">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请在上面完成相关信息的编写.信息编写要求，url不能为空，domain可填可不填，不填系统会默认解析，但解析出错该部分为null.
				其它部分为可填项.</div>
		</form>
	</div>

	<div class="div2">
		<font class="div3-p1">数据查询</font>
		<form action="query" method="POST" class="div2-form">
			<div class="div2-div1">
				<div class="div2-div1-1">
					请选择查询类型:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; url : <input
						type="radio" value="url" name="1" style="margin-right: 10px;"
						checked="checked" /> 域名 : <input type="radio" value="domain"
						name="1" style="margin-right: 10px" /> 描述 : <input type="radio"
						value="description" name="1" style="margin-right: 10px" /> 病毒名 : <input
						type="radio" value="virusname" name="1" style="margin-right: 1px" />

					<br /> 请输入查询关键字:&nbsp;&nbsp;&nbsp; <input type="text" name="value" />
				</div>
				<div class="div2-div1-2">
					<input type="submit" value="Submit" style="margin-right: 20px" /> <input
						type="reset" value="Reset" />
				</div>
			</div>
			<div class="div2-div2">
				<table class="table" align="center">
					<tr>
						<td width=8%>序号</td>
						<td width=15%>url</td>
						<td width=20%>域名</td>
						<td width=34%>描述</td>
						<td width=15%>病毒名</td>
						<td width=8%>标志</td>
					</tr>
				</table>
			</div>
		</form>
	</div>

	<div class="div3">
		<font class="div3-p1">数据更新</font>
		<form action="update" method="POST" class="div3-form">
			<div class="div3-div1">
				<font class="div3-infor">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请在中间框内选择依据的类型，并填入相应的原值，再在右边框内选择修改的类型即修改后的新值，注意左右选择不能重复</font>
				<div style="margin-left: 10%; margin-top: 20%;">
					<input type="submit" value="Submit" style="margin-right: 50px" /> <input
						type="reset" value="Reset" />
				</div>
			</div>
			<div class="div3-div2">
				<div>
					请输入原值 <input type="text" name="oldvalue" />
				</div>
				<div style="margin-left: 60px">
					url : <input type="radio" name="0" value="url"
						style="margin-right: 60px;" checked="checked" /> 域名 : <input
						type="radio" name="0" value="domain" />
				</div>
			</div>
			<div class="div3-div3">
				<div>
					请输入新值 <input type="text" name="newvalue" />
				</div>
				<div style="margin-left: 20px;">
					描述: <input type="radio" name="1" value="description"
						style="margin-right: 10px;" checked="checked" /> 标志: <input
						type="radio" name="1" value="flag" style="margin-right: 10px;" />
					域名: <input type="radio" name="1" value="domain"
						style="margin-right: 10px;" /> 病毒名: <input type="radio" name="1"
						value="virusname" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>