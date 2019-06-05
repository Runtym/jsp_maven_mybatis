package com.osf.test.ws;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;


public class MsgEncoder implements Encoder.Text<Message>{

	private Gson g = new Gson();
	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig arg0) {
	}

	@Override
	public String encode(Message msg) throws EncodeException {
		return g.toJson(msg);
	}
}
