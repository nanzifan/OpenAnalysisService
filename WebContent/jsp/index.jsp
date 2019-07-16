<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
font-style: 12px;
}
</style>
</head>
<body>
<!-- HTML表单：向服务器端提交数据请求 
     method: get方式 - 明文提交同时提数据大小限制在128K     www.baidu.com/xxx.html?keyword=xxxxxx&descript=xxxxxx
             post方式 -  密文提交同时提交数据大小无限制
-->
<form id="test_input" method="post" action="/OpenAnalysisService/TestServlet">
	<table>
		<tr>
			<td>input:</td>
			<td><input id="txtInput" type="text" name="txtInput"/></td>
			<td><input id="submit" type="submit" value="submit"/></td>
		</tr>
	</table>
</form>
<form id="services" method="post" action="/OpenAnalysisService/CallGraphDockerServlet">
	<table>
		<tr>
			<td><input type="submit" name="call_graph" id="call_graph" onClick="/OpenAnalysisService/CallGraphServlet" value="Call Graph"></td>
		</tr>
	</table>
</form>
</body>
</html>