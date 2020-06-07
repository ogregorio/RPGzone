package com.rpgzonewebrest.dto;

import java.util.ArrayList;
import java.util.List;

import com.rpgzonewebrest.models.game.Game;
import com.rpgzonewebrest.repository.GameDatabase;

public class RoomConfigDTO {
	private List<Game> games = new ArrayList<Game>();
	private List<String> gameRules = new ArrayList<String>();
	private List<String> plots = new ArrayList<String>();
	
	public RoomConfigDTO() {	
		this.setGames( ( new GameDatabase() ).getFreeGames());
		gameRules.add("Default");
		plots.add("Default");
		gameRules.add("Custom");
		plots.add("Custom");
	}
	
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public List<String> getGameRules() {
		return gameRules;
	}

	public void setGameRules(List<String> gameRules) {
		this.gameRules = gameRules;
	}

	public List<String> getPlots() {
		return plots;
	}

	public void setPlots(List<String> plots) {
		this.plots = plots;
	}
}
