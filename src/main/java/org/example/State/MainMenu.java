package org.example.Actions;

import org.example.GameContext;
import org.example.GameState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu implements GameState {
	@Override
	public void doAction(GameContext context) {
		System.out.print("Добро пожаловать в игру Быки и коровы\n\n"
			+ "1. Играть\n"
			+ "2. Посмотреть правила\n"
			+ "3. Выйти\n\n"
			+ "Выберите пункт меню: ");
		
		int setting = setSetting();
		
		switch (setting) {
			case (1):
				System.out.println("Игра\n");
				context.setState(new SetSettings());
				context.doAction();
				break;
			case (2):
				context.setState(new RulesMenu());
				context.doAction();
				break;
			case (3):
				System.out.println("Выход");
				break;
			default:
				System.out.println("Вы ввели неверное значение, введите верное значение");
				break;
		}
	}
	
	public int setSetting() {
		Scanner in = new Scanner(System.in);
		try {
			return in.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Ошибка ввода. Пожалуйста, введите целое число: ");
			in.nextLine();
			return setSetting();
		}
	}
}
