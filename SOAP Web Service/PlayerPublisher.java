package com.au.webservice.soap2;
import javax.xml.ws.Endpoint;

public class PlayerPublisher {
	public static void main(String[] args) {
		  Endpoint.publish("http://localhost:8036/",new PlayersImpl());
		 }

}