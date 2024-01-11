package org.example.State;

import org.example.Checks.Bull;
import org.example.Checks.Cow;
import org.example.GameContext;
import org.example.Settings;

import java.util.Arrays;

public class ShowResult implements GameState {
	Bull bull = new Bull();
	private int countOfBulls = bull.countBulls();
	Cow cow = new Cow();
	private int countOfCows = cow.countCows();
	private int[] secret = Settings.getInstance().getSecret();

	@Override
	public void doAction(GameContext context) {
		System.out.println();
		if (countOfBulls == secret.length) {
			System.out.println("Поздравляю! Вы угадали число " + Arrays.toString(secret) + " Поздравляем!");
			System.out.println("Вы будете возвращены в меню\n");

			context.setState(new MainMenu());
			context.doAction();
		} else {
			System.out.println("Количество быков: " + countOfBulls);
			System.out.println("Количество коров: " + countOfCows + "\n");
			
			context.setState(new PlayGame());
			context.doAction();
		}
	}
}
