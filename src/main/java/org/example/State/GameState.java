package org.example.State;

import org.example.GameContext;

public interface GameState {
	void doAction(GameContext context);
}
