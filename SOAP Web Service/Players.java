package com.au.webservice.soap2;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface Players {
	@WebMethod
	public void add(int i,String n, String coun, String pos, int goal, int game);
	@WebMethod
	public ArrayList<String> showAllPlayersByCountry(String country);
	@WebMethod
	public void deletePlayer(int i);
	@WebMethod
	public void UpdatePlayer(int i,String n, String coun, String pos, int goal, int game);
	@WebMethod
	public ArrayList<String> showPlayersById(int i);
}