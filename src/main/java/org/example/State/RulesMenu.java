package org.example.State;

import org.example.GameContext;

public class RulesMenu implements GameState {
	@Override
	public void doAction(GameContext context) {
		System.out.print("\nПравила игры\n\n"
			+ "Компьютер загадывает число, а человек — отгадывает его\n"
			+ "После каждого ввода числа, компьютер выводит количество быков и коров в нем\n"
			+ "Коровой называется цифра, угаданная без совпадения позиции,\n"
			+ "а быком — цифра, угаданная с совпадением позиции\n\n");
		
		context.setState(new MainMenu());
		context.doAction();
	}
}
