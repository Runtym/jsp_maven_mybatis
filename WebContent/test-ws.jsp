<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	var socket;
	function sendMsg(btn){
		if(btn.innerHTML==='접속'){
			var name = document.querySelector('#name').value
			socket = new WebSocket('ws://192.168.0.2/' + name);
			socket.onopen = function(e){
				document.querySelector('#rDiv').value += '====접속완료===';
			}
			
			socket.onerror = function(e){
				alert('에러남!');
			}
			socket.onmessage = function(evt){
				document.querySelector('#rDiv').value += evt.data + '\n';
			}
			btn.innerHTML = '전송';
		}else if(btn.innerHTML==='전송'){
			var msg = document.querySelector('#msg').value; 
			socket.send(msg);
		}
	}
</script>
<textarea id="rDiv" rows="20" cols="50"></textarea><br>
<input type="text" id="name" placeholder="이름">
<input type="text" id="msg">
<button onclick="sendMsg(this)">접속</button>
</body>
</html>










