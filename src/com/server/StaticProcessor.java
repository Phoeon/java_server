package com.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class StaticProcessor implements Processor{
	public void process(Request request, Response response){
		try {
			File file = new File(Constant.staticRoot+request.getUri());
			if(file.exists()){
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				PrintWriter pw = response.getPrintWriter(true);
				String line = null;
				boolean loop = true;
				while(loop){
					if(br.ready()){						
						while((line=br.readLine())!=null){
							pw.write(line);
						}
						loop = false;
					}
				}
				br.close();
				pw.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				response.getOutputStream().close();
				request.getInputStream().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void service(Request req, Response res) {
		// TODO Auto-generated method stub
		process(req,res);
	}
	
}
