<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:if test="${msg!=null}">
<script>
	alert('로그인이 실패하였습니다.');
</script>
</c:if>
<body>
<form method="post" action="/mem/login">
	아이디 : <input type="text" name="miId"><br>
	비번 : <input type="password" name="miPwd"><br>
	<button>로그인</button>
</form>
</body>
</html>