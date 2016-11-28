package com.codeprep.client;

import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.codeprep.constants.Constants;

/**
 * The Class ClientUtil.
 */
public class ClientUtil {
	
	private ClientUtil(){
	}

	private static TransportClient client;

	public static TransportClient getInstance() {

		if (client == null) {
			client = createTransportClient();
		}
		return client;
	}

	private static TransportClient createTransportClient() {
		
		TransportClient client = null;
		Properties configProperties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = ClientUtil.class.getClassLoader().getResourceAsStream(Constants.CONFIG_FILE.getName());
			configProperties.load(inputStream);
			client = TransportClient.builder().build()
					.addTransportAddress(new InetSocketTransportAddress(
							InetAddress.getByName(configProperties.getProperty(Constants.ELASTICSEARCH_HOST.getName())),
							Integer.valueOf(configProperties.getProperty(Constants.ELASTICSEARCH_PORT.getName()))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}
}
