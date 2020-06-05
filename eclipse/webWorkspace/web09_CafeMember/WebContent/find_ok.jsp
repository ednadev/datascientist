<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% MemberVO vo = (MemberVO) request.getAttribute("id"); %>
	<h2>회원 검색 결과</h2>
	<ul>
		<li>아이디 : <%= vo.getId() %></li>
		<li>이름 : <%= vo.getName() %></li>
		<li>주소 : <%= vo.getAddress() %></li>
	</ul>
</body>
</html>