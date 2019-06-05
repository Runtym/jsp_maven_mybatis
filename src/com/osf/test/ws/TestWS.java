package com.osf.test.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/{name}",
decoders = MsgDecoder.class,
encoders = MsgEncoder.class
		)
public class TestWS {
	private static final List<Session> ssList = new ArrayList<>();
	private static final List<String> names = new ArrayList<>();
	@OnOpen
	public void onOpen(@PathParam("name") String name,Session ss) {
		if(ssList.indexOf(ss)==-1) {
			ssList.add(ss);
			names.add(name);
		}
		System.out.println(names);
		ss.getUserProperties().put("name",name);
		for(Session session : ssList) {
			try {
				Message msg = new Message();
				msg.setName(name);
				msg.setMsg(name + "님 접속");
				msg.setOpen(true);
				msg.setTotal(ssList.size());
				msg.setNames(names);
				session.getBasicRemote().sendObject(msg);
			} catch (IOException | EncodeException e) {
				e.printStackTrace();
			}
		}
	}
	
	@OnMessage
	public void onMessage(Message msg, Session ss) {
		for(Session session : ssList) {
			try {
				String name = (String) ss.getUserProperties().get("name");
				msg.setName(name);
				msg.setTotal(ssList.size());
				if(msg.getTargetName()!=null) {
					String targetName = (String) session.getUserProperties().get("name");
					if(targetName.equals(msg.getTargetName())) {
						session.getBasicRemote().sendObject(msg);
					}
				}else {
					session.getBasicRemote().sendObject(msg);
				}
			} catch (IOException | EncodeException e) {
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
		String name = (String) ss.getUserProperties().get("name");
		names.remove(name);
		System.out.println(names);
		for(Session session : ssList) {
			try {
				Message msg = new Message();
				msg.setName(name);
				msg.setMsg(name + "님 접속 종료");
				msg.setClose(true);
				msg.setTotal(ssList.size());
				msg.setNames(names);
				session.getBasicRemote().sendObject(msg);
			} catch (IOException | EncodeException e) {
				e.printStackTrace();
			}
		}
	}
}
