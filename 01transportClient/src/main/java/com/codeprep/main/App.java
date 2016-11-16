package com.codeprep.main;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.client.transport.TransportClient;

import com.codeprep.client.ClientUtil;

public class App {
	
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		
		TransportClient client = null;
		try{
			client = ClientUtil.getInstance();
			System.out.println(client);
		}finally{
			if(client != null){
				client.close();
			}
		}
		
	}

}
