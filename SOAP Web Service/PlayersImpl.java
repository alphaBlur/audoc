package com.au.webservice.soap2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface="com.au.webservice.soap2.Players")
public class PlayersImpl implements Players{
	HashMap<Integer,MyPlayers> allplayers = new HashMap<Integer,MyPlayers>();
	
	@Override
	public void add(int i, String n, String coun, String pos, int goal, int game) {
		MyPlayers temp = new MyPlayers(i, n,  coun,  pos,  goal,  game);
		allplayers.put(i, temp);
	}
	
	public class MyPlayers {
		
		int id;
		String name;
		String country;
		String position;
		int goals;
		int games;
		
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public String getCountry() {
			return country;
		}
		public String getPosition() {
			return position;
		}
		public int getGoals() {
			return goals;
		}
		public int getGames() {
			return games;
		}
		public MyPlayers(int i,String n, String coun, String pos, int goal, int game) {
			this.id=i;
			this.name=n;
			this.country=coun;
			this.position=pos;
			this.goals=goal;
			this.games=game;
		}
	}
	@Override
	public void deletePlayer(int i) {
		allplayers.remove(i);		
	}

	@Override
	public void UpdatePlayer(int i, String n, String coun, String pos, int goal, int game) {
		allplayers.remove(i);
		MyPlayers temp = new MyPlayers(i, n,  coun,  pos,  goal,  game);
		allplayers.put(i,temp);
	}

	@Override
	public ArrayList<String> showAllPlayersByCountry(String country) {
		ArrayList<String> temp = new ArrayList<String>();
		for(Map.Entry<Integer, MyPlayers> e: allplayers.entrySet()) {
			if( allplayers.get(e.getKey()).getCountry().equals(country)) {
				temp.add(allplayers.get(e.getKey()).getName());
			}
		}
		return temp;
	}
	public ArrayList<String> showPlayersById(int i) {
		ArrayList<String> l = new ArrayList<String>();
		for(Map.Entry<Integer, MyPlayers> e: allplayers.entrySet()) {
			if( e.getKey()==i) {
				l.add(allplayers.get(e.getKey()).getName());
				l.add(Integer.toString(allplayers.get(e.getKey()).getId()));
				l.add(allplayers.get(e.getKey()).getPosition());
				l.add(allplayers.get(e.getKey()).getCountry());
				l.add(Integer.toString(allplayers.get(e.getKey()).getGoals()));
				l.add(Integer.toString(allplayers.get(e.getKey()).getGames()));
			}
		}
		return l;
	}

}
