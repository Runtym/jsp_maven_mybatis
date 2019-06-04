<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	<c:if test="${cnt=='1'}">
		alert('회원가입 성공');
	</c:if>
	<c:if test="${cnt!='1'}">
		alert('회원가입 실패');
	</c:if>
</script>
</body>
</html>