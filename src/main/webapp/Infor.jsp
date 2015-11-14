
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="class/main.css" />
<title>查询数据</title>
<%@ page import="org.json.JSONObject"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="org.json.JSONArray"%>
<%@ page import="java.util.Vector"%>
<style type="text/css">
td {
	border: 1px solid #000;
	bgcolor: #FFFFAA align="center";
}
tr {
	bgcolor: #FFFFAA align="center";
}
</style>
</head>
<body>
	<center>数据查询</center>
	<hr><br>
	<table align="center" style="word-break: break-all; word-wrap: break-all;" width=100%
		border=10 align="center">
		<tr bgcolor=#FFFFAA align="center">
			<td width=8%>序号</td>
			<td width=15%>名称</td>
			<td width=20%>进购总数</td>
			<td width=34%>剩余数量</td>
		</tr>
		<%
			JSONObject json=null;JSONArray array=null;
			Object data=request.getAttribute("data");
			try {
				json = new JSONObject(data.toString());
			} catch (Exception e) {
				System.out.println(e.toString());
			} 
			if(json.has("result")){
				array= json.getJSONArray("result");;	
			}
			else
				return;
			//out.write(array.toString());
			for(int i=0;i<array.length();i++){
				JSONObject jo = (JSONObject) array.get(i);
		%>
		<tr bgcolor=#FFFFAA align="center">
			<td><% out.print(jo.getInt("no")); %></td>
			<td><% out.print(jo.getString("name")); %></td>
			<td><% out.print(jo.getInt("total")); %></td>
			<td><% out.print(jo.getInt("left")); %></td>

		</tr>
		<%
			}
		%>
	</table>
</body>
</html>