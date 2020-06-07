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
		
		super.getGameRules().add("Pro Default");
		super.getPlots().add("Pro Default");	
		super.getGameRules().add("Pro Custom");
		super.getPlots().add("Pro Custom");
	}
}
