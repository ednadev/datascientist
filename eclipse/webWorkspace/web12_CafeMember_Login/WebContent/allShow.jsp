<%@page import="java.util.ArrayList"%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<% if(request.getParameter("name")!=null) { %>
		<%= request.getParameter("name") %> 님이 가입하셨습니다.
	<% } %>
	<h2>전체 회원 목록</h2>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
		</tr>
		<%  ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
			for(int i=0; i<list.size(); i++) {
		%>
		<tr>
			<td><%= list.get(i).getId() %></td>
			<td><%= list.get(i).getName() %></td>
			<td><%= list.get(i).getAddress() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>