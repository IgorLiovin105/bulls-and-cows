package org.example;

import org.example.State.*;
public class GameContext {
	private GameState state;
	private final MainMenu mainMenu = new MainMenu();
	private final RulesMenu rulesMenu = new RulesMenu();
	private final SetSettings setSettings = new SetSettings();
	private final PlayGame playGame = new PlayGame();
	private final ShowResult showResult = new ShowResult();
	public GameContext() {
		this.state = mainMenu;
		this.state.doAction(this);
	}
	
	public void setState(String stateName) {
		switch (stateName) {
			case "MainMenu":
				this.state = mainMenu;
				this.state.doAction(this);
				break;
			case "RulesMenu":
				this.state = rulesMenu;
				this.state.doAction(this);
				break;
			case "SetSettings":
				this.state = setSettings;
				this.state.doAction(this);
				break;
			case "PlayGame":
				this.state = playGame;
				this.state.doAction(this);
				break;
			case "ShowResult":
				this.state = showResult;
				this.state.doAction(this);
				break;
			default:
				break;
		}
	}
}
