<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		var xhr;
		function startRequest() {
			var id = document.getElementById('memberId').value;

			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = callback;
			xhr.open("get", "find.do?memberId=" + id);
			xhr.send(null);
		}
		function callback() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("memberIdView").innerHTML 
						= "<font color=green size=4>" + xhr.responseText + "</font>";
				}
			}
		}
	</script>
</head>
<body>
	<h2 align="center">ID LIST...</h2>
	<h3 align="center">리스트 폼에서 특정한 아이디를 선택하세요..</h3>
	<select id="memberId" name="memberId" onchange="startRequest()">
		<option selected disabled>==== id choice ====</option>
		<c:forEach items="${list}" var="memId">
			<option>${memId.id}</option>
		</c:forEach>
	</select>
	<span id="memberIdView"></span>
</body>
</html>