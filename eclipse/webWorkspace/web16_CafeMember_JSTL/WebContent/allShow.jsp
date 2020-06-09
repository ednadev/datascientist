<%@page import="java.util.ArrayList"%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table {
			border-collapse: collapse;
		}
		table td {
			padding: 5px;
		}
	</style>
</head>
<body>
	<h3 align="center">회원 명단 보기</h2>
	<table border="2" width="350" bgcolor="yellow" align="center">
		<c:forEach items="${list}" var="member">
			<tr>
				<td>${member.id}</td>
				<td>${member.name}</td>
				<td>${member.address}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>