<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/mem/signin" method="post" enctype="multipart/form-data">
아이디 : <input type="text" name="miId" id="miId"><br>
비밀번호 : <input type="password" name="miPwd" id="miPwd"><br>
이름 : <input type="text" name="miName" id="miName"><br>
이메일 : <input type="text" name="miEmail" id="miEmail"><br>
성별 : <label for="m">남</label><input type="radio" name="miTrans" id="m" checked value="1">
<label for="f">여</label><input type="radio" name="miTrans" id="f" value="2">
생년월일 : <input type="date" name="miBirth" id="miBirth"><br>
주소코드 : <input type="text" name="miZipcode" id="miZipcode"><br>
주소1 : <input type="text" name="miAddr1" id="miAddr1"><br>
주소2 : <input type="text" name="miAddr2" id="miAddr2"><br>
프사 : <input type="file" name="miMainImg" id="miMainImg"><br>
별명 : <input type="text" name="miNick" id="miNick"><br>
기타정보 : <textarea name="miEtc" id="miEtc"></textarea><br>
<button>회원가입</button>
</form>
</body>
</html>