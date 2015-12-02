package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request {
	private InputStream is ;
	private String line ;
	private String uri = "/";
	public Request(InputStream is) {
		super();
		this.is = is;
		init();
	}
	private void init(){
		try {
			boolean loop = true;
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while(loop){
				if(br.ready()){
					line = br.readLine();
//					System.out.println(line);
					if(line!=null)uri = line.split(" ")[1]; 
					loop = false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUri(){
		return uri;
	}
	public InputStream getInputStream(){
		return is;
	}
	public boolean isStaticType(){
		return uri.contains(".");
	}
	
}
