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
			socket.onopen = function(evt){ 
				document.querySelector('#name').disabled = true;
			}
			
			socket.onerror = function(e){
				alert('에러남!');
			}
			socket.onmessage = function(evt){
				var name = document.querySelector('#name').value
				var msg = JSON.parse(evt.data);
				var text = msg.name + ' : ' + msg.msg;
				if(msg.targetName){
					text = '[귓속말 : ' + text +']';
				}
				if(msg.open||msg.close){
					changeSelectBox(msg);
				} 
				document.querySelector('#rDiv').value += text + '\n';
				document.querySelector('#totalDiv').innerHTML = '총 : ' + msg.total + '명';
			}
			btn.innerHTML = '전송';
		}else if(btn.innerHTML==='전송'){
			var param = {};
			var msg = document.querySelector('#msg').value;
			param.msg = msg;
			if(document.querySelector('#names').value){
				param.targetName = document.querySelector('#names').value;
			}
			socket.send(JSON.stringify(param));
		}
	}
	function changeSelectBox(msg){
		var name = document.querySelector('#name').value
		var names = msg.names;
		var options = '<option value="">=선택=</option>';
		for(var na of names){
			if(na!=name){
				options += '<option value="' + na +'">' + na + '</option>';
			}
		}
		console.log(options);
		console.log(names);
		document.querySelector('#names').innerHTML = options;
		document.querySelector('#names').style.display='';
	}
</script>
<textarea id="rDiv" rows="20" cols="50"></textarea><br>
<select id="names" style="display:none">
</select>

<input type="text" id="name" placeholder="이름">
<input type="text" id="msg">
<button onclick="sendMsg(this)">접속</button>
<div id="totalDiv"></div>
</body>
</html>










