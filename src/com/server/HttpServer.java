package com.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpServer {
	public static void main(String[] args) {
		tip(args);
		listening();
	}
	private static void tip(String []args){
		switch(args.length){
		case 3 : Constant.port = Integer.parseInt(args[2]);
		case 2 : Constant.host = args[1];
		case 1 : Constant.staticRoot = args[0];break;
		default : ;
		}
		System.out.println("runing server at host : "+Constant.host+" , port : "+Constant.port);
		System.out.println("press CTRL+C to stop the server");
	}
	public static void listening(){
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(Constant.port, Constant.backlog, InetAddress.getByName(Constant.host));
			while(true){
				Socket s = server.accept();
				Dispatcher dp = new Dispatcher(s.getOutputStream(), s.getInputStream());
				dp.service();
				s.close();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
