package org.example;

import org.example.State.GameState;

public class GameContext {
	private GameState state;
	
	public GameContext(GameState state) {
		this.state = state;
	}
	
	public void setState(GameState state) {
		this.state = state;
	}
	
	public void doAction() {
		this.state.doAction(this);
	}
}
