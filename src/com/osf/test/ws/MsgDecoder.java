package com.osf.test.ws;

import java.util.List;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import lombok.Data;

@Data
class Message{
	private String name;
	private String targetName;
	private String msg;
	private boolean open;
	private boolean close;
	private Integer total;
	private List<String> names;
}

public class MsgDecoder implements Decoder.Text<Message>{

	private Gson g = new Gson();
	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig arg0) {
	}

	@Override
	public Message decode(String s) throws DecodeException {
		System.out.println(s);
		return g.fromJson(s, Message.class);
	}

	@Override
	public boolean willDecode(String s) {
		return true;
	}

}
