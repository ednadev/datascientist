<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${vo!=null}">
		session.invalidate();
		<script>
			alert("로그아웃 하셨습니다");
			location.href="login.html";
		</script>
	</c:when>
	<c:otherwise>
		<b><a href="login.html">로그인부터</a></b>
	</c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function logoutpopup() {
			alert("Log Out!!!");
		}
	</script>
</head>
<body>

</body>
</html>