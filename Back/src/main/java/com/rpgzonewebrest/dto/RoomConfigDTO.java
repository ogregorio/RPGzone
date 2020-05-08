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
		gameRules.add("- Teste regras  !!!- Teste regras  !!!- Teste regras  !!!- Teste regras  !!! ");
		plots.add("Enredos normais teste 1 Enredos normais teste 1 Enredos normais teste 1 Enredos normais teste 1 Enredos normais teste 1 ");
		gameRules.add("- Teste regras2 !!!- Teste regras2  !!!- Teste regras2  !!!");
		plots.add("Enredos normais teste 2 Enredos normais teste 2 Enredos normais teste 2 Enredos normais teste 2 Enredos normais teste 2 ");
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
