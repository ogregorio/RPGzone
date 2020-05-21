package com.rpgzonewebrest.dto;

import com.rpgzonewebrest.models.game.Game;
import com.rpgzonewebrest.repository.GameDatabase;
import java.util.List;

public class RoomConfigProDTO extends RoomConfigDTO {
	
	public RoomConfigProDTO() {
		super();
		List<Game> proGames = ( new GameDatabase() ).getPROgames();
		for(Game game : proGames){
			super.getGames().add(game);
		}
		
		super.getGameRules().add("- teste de regras de jogo Pro 1  - teste de regras de jogo Pro 1  - teste de regras de jogo Pro 1  - teste de regras de jogo Pro 1  ");
		super.getPlots().add("teste de enredo Pro 1  teste de enredo Pro 1  teste de enredo Pro 1  teste de enredo Pro 1  teste de enredo Pro 1  teste de enredo Pro 1  teste de enredo Pro 1  teste de enredo Pro 1  ");	
		super.getGameRules().add("- teste de regras de jogo Pro 2 - teste de regras de jogo Pro 2 - teste de regras de jogo Pro 2 - teste de regras de jogo Pro 2 - teste de regras de jogo Pro 2   !!! ");
		super.getPlots().add("teste de enredo Pro 2 teste de enredo Pro 2 teste de enredo Pro 2 teste de enredo Pro 2 teste de enredo Pro 2 teste de enredo Pro 2 ");
	}
}
