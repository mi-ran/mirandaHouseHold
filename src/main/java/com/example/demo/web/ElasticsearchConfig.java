package com.example.demo.web;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SuppressWarnings("deprecation")
@Configuration
@EnableElasticsearchRepositories
public class ElasticsearchConfig {

	@Value("${elasticsearch.host}")
	private String host;
	
	@Value("${elasticsearch.port}")
	private int port;
	
	@Value("${elasticsearch.clustername}")
	private String clusterName;
	
	@Bean
	public Client client() throws Exception {
		System.out.println(host);
		System.out.println(port);
		System.out.println(clusterName);
		System.out.println("jmrjmr");
		
		Settings esSettings = Settings.builder()
				.put("cluster.name" , clusterName)
				.build();
		
		Client client = new PreBuiltTransportClient(esSettings)
				.addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
		return client;
	}
	
	@Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}
