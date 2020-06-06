package com.rpgzonewebrest.repository;
import java.util.ArrayList;
import java.util.List;

import com.rpgzonewebrest.models.game.Game;

public class GameDatabase {

	private List<Game> freeGames = new ArrayList<Game>();
	private List<Game> PROGames = new ArrayList<Game>();
	
	public GameDatabase() {
		this.genFreeGamesDB();
		this.genPROGamesDB();
	}
	
	public void genFreeGamesDB() {
	freeGames.add(new Game(
	                "EpicoRPG",
	                2016,
	                "Rafael Lopes Vivian",
	                "Portuguese",
                        "Epico.jpg",
                        "https://epicorpg.com.br/downloads/Epico-RPG-Beta-5-final.pdf"
			));
	freeGames.add(new Game(
			"Call of Cthulhu", 
			1981, 
			"Chaosium", 
			"Portuguese", 
			"Warhammer.jpeg",
			"https://www.chaosium.com/content/FreePDFs/CoC/CHA23131%20Call%20of%20Cthulhu%207th%20Edition%20Quick-Start%20Rules.pdf"
			));
	freeGames.add(new Game(
			"Numenera", 
			2013, 
			"Monte Cook Games", 
			"English", 
			"Numenera.jpg",
			"https://i.4pcdn.org/tg/1442460989620.pdf"
			));
	freeGames.add(new Game(
			"Dungeon World", 
			2012, 
			"RNDM Games", 
			"English", 
			"DungeonWorld.jpg",
			"https://dungeon-world.com/downloads/Dungeon_World_Play_Sheets.pdf"
			));
	}
	public void genPROGamesDB() {
		PROGames.add(new Game(
				"Dungeons & Dragons", 
				1974, 
				"TSR, Inc.", 
				"English", 
				"Dungeons_&_Dragons.jpg",
				"https://dnd5ed.github.io/livros/GM.pdf"
				));
		PROGames.add(new Game(
				"Cyberpunk 2020", 
				1988, 
				"R. Talsorian Games", 
				"English", 
				"Cyberpunk.jpg",
				"https://img.fireden.net/tg/image/1452/60/1452607540655.pdf"
				));
		PROGames.add(new Game(
				"Deadlands", 
				1996, 
				"Pinnacle Entertainment Group", 
				"English", 
				"Deadlands.png",
				"http://www.angelfire.com/scifi/lordmcdeathcastle/DeadlandsPlayersGuide.pdf"
				));
		PROGames.add(new Game(
				"Old Dragon", 
				2010, 
				"Redbox Editora", 
				"Portuguese", 
				"Old_Dragon.jpg",
				"https://newtonrocha.files.wordpress.com/2014/05/od-manual-fast-play-v1-0.pdf"
				));
		PROGames.add(new Game(
				"Shadowrun", 
				1989, 
				"FASA", 
				"English", 
				"Shadowrun.jpg",
				"http://shadowruntabletop.com/wp-content/uploads/2013/02/E-CAT27QSR_SR5-Quick-Start-Rules.pdf"
				));
		PROGames.add(new Game(
				"RuneQuest", 
				1978, 
				"Chaosium", 
				"English", 
				"Runequest.jpg",
				"https://www.chaosium.com/content/FreePDFs/RuneQuest/CHA4027%20-%20RuneQuest%20Quickstart.pdf"
				));
		PROGames.add(new Game(
			        "Blades in the Dark", 
			        2017, 
			        "Evil Hat Productions", 
			        "Portuguese", 
			        "Blades_in_the_Dark.jpg",
			        "https://bladesinthedark.com/sites/default/files/blades_playerkit_v8_2.pdf"
				));
	}
	
	public List<Game> getFreeGames(){
		return freeGames;
	}
	public List<Game> getPROgames() {
		return PROGames;
	}
}
