package org.example.State;

import org.example.GameContext;
import org.example.GameFileFacade;
import org.example.Settings;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class PlayGame implements GameState {
	@Override
	public void doAction(GameContext context) {
		Settings settings = Settings.getInstance();
		
		int length = settings.getLength();
		boolean isRepeat = settings.getIsRepeat();
		
		int[] guess = play(length, isRepeat);
		
		GameFileFacade.writeToFile(guess);
		context.setState(new ShowResult());
		context.doAction();
	}
	
	private int[] play(int length, boolean isRepeat) {
		String temp;
		Scanner in = new Scanner(System.in);
		
		while (true) {
			try {
				System.out.print("Введите ваш вариант числа: ");
				temp = in.nextLine();
				
				temp = temp.replaceAll("[^\\d]", "");
				
				if (length != temp.length()) {
					System.out.println("Неверное число. Пожалуйста, введите число длиной " + length + " и повторите попытку");
					continue;
				}
				
				if (!isRepeat && hasRepeatingDigits(temp)) {
					System.out.println("Повторяющиеся цифры запрещены. Пожалуйста, введите число без повторов и повторите попытку");
					continue;
				}
				
				if (!isValidNumber(temp)) {
					System.out.println("Неверный формат числа. Пожалуйста, введите число без пробелов и повторите попытку");
					continue;
				}
				
				break;
			} catch (InputMismatchException e) {
				System.out.print("Ошибка ввода. Пожалуйста, введите число: ");
				in.nextLine();
			}
		}
		
		return toIntArray(temp, length);
	}
	
	private boolean hasRepeatingDigits(String number) {
		Set<Character> uniqueDigits = new HashSet<>();
		
		for (char digit : number.toCharArray()) {
			if (!uniqueDigits.add(digit)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isValidNumber(String number) {
		return number.matches("[0-9]+");
	}
	
	private int[] toIntArray(String temp, int length) {
		int[] guess = new int[length];
		for (int i = 0; i < length; i++) {
			guess[i] = temp.charAt(i) - '0';
		}
		return guess;
	}
}
