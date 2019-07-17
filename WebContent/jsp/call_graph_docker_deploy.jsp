<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script language="javascript">
 	function removeDockerByID(){
 		var id = document.getElementById("docker_id").value;
 		
 		//alert("test message dd" + id);
 		if(confirm("Remove Docker?")){
 			window.location = "/OpenAnalysisService/CallGraphDockerRemoveServlet?dockerID="+id;
 		}
 		//window.location = "/OpenAnalysisService/CallGraphDockerDeleteServlet?dockerID="+dockerID;
 	}
</script>


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
<form id="form" method="post" action="/OpenAnalysisService/TestServlet">
	<table>
		<tr>
			<td>Docker id:</td>
			<td><a>${requestScope.result}</a></td>
		</tr>
		<tr>
<!-- 			<td><input type="button" name="main_page" id="main_page" onClick="window.location.href = 'jsp/index.jsp';" value="main page"></td> -->
			<td><input type="button" name="delete_docker" id="delete_docker" onClick="javascript:removeDockerByID();" value="Delete docker"></td>	
		</tr>
	</table>
	<input type="hidden"  name="docker_id" id="docker_id" value="${requestScope.result}">
</form>
<!-- <input type="button" name="delete_docker" id="delete_docker" onClick="javascript:removeDockerByID("abc");" value="Delete docker"> -->
<!-- <input type="button" name="t1" id="t1" onClick="test()" value="t1"> -->
<!-- <input type="button" name="t2" id="t2" onClick="javascript:test()" value="t2"> -->
<!-- <input type="button" name="t2" id="t3" onClick="javascript:test()" value="t2"> -->


<form id="form" method="post" action="/OpenAnalysisService/CallGraphDockerExecuteServlet">
	<table>
		<tr>
			<td>Argument: </td>
			<td><input id="argument" type="text" name="argument"/></td>
		</tr>
		<tr>
			<td><input id="submit" type="submit" value="Execute"/></td>
		</tr>
	</table>
</form>
</body>
</html>