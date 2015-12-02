package com.server;

import java.io.InputStream;
import java.io.OutputStream;

public class Dispatcher {
	private Response response ;
	private Request request  ;
	public Dispatcher(OutputStream os, InputStream is) {
		super();
		this.response = new Response(os);
		this.request = new Request(is);
	}
	
	public void service(){
		if(request.isStaticType()){
			Processor processor = new StaticProcessor();
			processor.service(request,response);
		}
	}
}
