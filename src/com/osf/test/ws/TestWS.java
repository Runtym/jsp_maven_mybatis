package com.osf.test.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/{name}")
public class TestWS {
	private static final List<Session> ssList = new ArrayList<>();
	
	@OnOpen
	public void onOpen(@PathParam("name") String name,Session ss) {
		if(ssList.indexOf(ss)==-1) {
			ssList.add(ss);
		}
		System.out.println("현재접속자수 : " + ssList.size());
		ss.getUserProperties().put("name",name);

		for(Session session : ssList) {
			if(ss!=session) {
				try {
					
					session.getBasicRemote().sendText(name + "님 접속");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@OnMessage
	public void onMessage(String msg, Session ss) {
		for(Session session : ssList) {
			try {
				String name = (String) ss.getUserProperties().get("name");
				session.getBasicRemote().sendText(name + ":" + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@OnError
	public void onerror(Throwable t) {
		System.out.println(t.getMessage());
	}
	@OnClose
	public void onClose(Session ss) {
		ssList.remove(ss);
	}
}
