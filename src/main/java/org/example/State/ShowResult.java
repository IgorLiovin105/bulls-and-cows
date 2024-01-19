package org.example.State;

import org.example.Checks.Bull;
import org.example.Checks.Cow;
import org.example.GameContext;
import org.example.Settings;

import java.util.Arrays;

public class ShowResult implements GameState {
	private Bull bull = new Bull();
	private Cow cow = new Cow();
	
	@Override
	public void doAction(GameContext context) {
		Settings settings = Settings.getInstance();
		int countOfBulls = this.bull.countBulls(settings.secret, settings.length);
		int countOfCows = this.cow.countCows(settings.secret, settings.length);
		if (countOfBulls == settings.length) {
			System.out.println("Вы угадали число " + Arrays.toString(settings.secret) + " Поздравляем!");
			System.out.println("Вы будете возвращены в меню\n");
			context.setState("MainMenu");
		} else {
			System.out.println("Количество быков: " + countOfBulls);
			System.out.println("Количество коров: " + countOfCows + "\n");
			context.setState("PlayGame");
		}
	}
}

