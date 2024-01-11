package org.example;


import org.example.State.MainMenu;

public class Main {
	public static void main(String[] args) {
		GameContext context = new GameContext(new MainMenu());
		context.doAction();
	}
}