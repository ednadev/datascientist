<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function closeWindow(result) {
		//확인버튼 누르면 이곳으로.....여기서 원래 회원가입폼을 제어해야한다.
		var of = window.opener.document.registerForm;
		if(result=='true') { //아이디 사용못한다면...
			of.id.value="";
			of.id.focus();
		}else{               //아이디 사용할 수 있다면
			of.password.focus();
			of.id.readOnly = true;
		}
		self.close();
		opener.SetValue(result);
	}
</script>
</head>
<body bgcolor="orange">
	<c:set var="message" value="해당 ID를 사용할 수 없음"/>
	
	<c:if test="${!flag}">
		<c:set var="message" value="해당 ID를 사용할 수 있음"/>
	</c:if>
	
	${param.id}, ${message}
	<input type="button" value="확인" onclick="closeWindow('${flag}')">
	
	<%-- <c:choose>
		<c:when test="${flag==false}">
			<style>
				body {
					background: orange;
				}
			</style>
			<p>${param.id}</p>
			<p style="color: blue;">사용가능</p>
			<button onclick="check()">확인</button>
		</c:when>
		<c:otherwise>
			<p style="color: red;">사용불가</p>
		</c:otherwise>
	</c:choose> --%>
</body>
</html>