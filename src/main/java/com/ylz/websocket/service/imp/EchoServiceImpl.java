package com.ylz.websocket.service.imp;

import com.ylz.websocket.service.EchoService;

public class EchoServiceImpl implements EchoService {
	private final String echoFormat;

	public EchoServiceImpl(String echoFormat) {
		this.echoFormat = (echoFormat != null) ? echoFormat : "%s";
	}

	@Override
	public String getMessage(String message) {
		return String.format(this.echoFormat, message);
	}
}
