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
</head>
<body>

<a>docker ID is: ${requestScope.dockerID }</a>
<br><a>Running result is: </a>
<pre>
${requestScope.result}
</pre>

<button name="main_page" id="main_page" onClick="window.location.href = 'jsp/index.jsp';">main page</button>
<button name="delete_docker" id="delete_docker" onClick="javascript:removeDockerByID();">Delete docker</button>
<input type="hidden"  name="docker_id" id="docker_id" value="${requestScope.dockerID}">


<!-- <table>
	<tr>
		<td><input type="button" name="main_page" id="main_page" onClick="window.location.href = 'jsp/index.jsp';" value="main page"></td>
		<td><input type="button" name="delete_docker" id="delete_docker" onClick="javascript:removeDockerByID();" value="Delete docker"></td>	
	</tr>
</table> -->


<%-- <form id="form" method="post" action="/OpenAnalysisService/TestServlet">
	<table>
		<tr>
			<td>dockerID:</td>
			<td>${requestScope.dockerID }</td>
		</tr>
		<tr>
			<td>Running result is:</td>
		</tr>
		<tr>
			<td>${requestScope.result}</td>
		</tr>
		<tr>
			<td><input type="button" name="main_page" id="main_page" onClick="window.location.href = 'jsp/index.jsp';" value="main page"></td>
			<td><input type="button" name="delete_docker" id="delete_docker" onClick="javascript:removeDockerByID();" value="Delete docker"></td>	
		</tr>
	</table>
	<input type="hidden"  name="docker_id" id="docker_id" value="${requestScope.dockerID}">
</form> --%>
</body>
</html>