package com.server;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {
	public Response(OutputStream os) {
		super();
		this.os = os;
	}

	private OutputStream os ;
	
	public OutputStream getOutputStream(){
		return os;
	}
	
	public PrintWriter getPrintWriter(boolean autoFlush){
		return new PrintWriter(getOutputStream(),autoFlush);
	}
}
