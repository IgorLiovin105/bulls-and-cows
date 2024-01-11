package org.example.State;

import org.example.GameContext;
import org.example.Settings;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SetSettings implements GameState {
	@Override
	public void doAction(GameContext context) {
		boolean isRepeat = setIsRepeat();
		int length = setLength();
		int[] secret = generateSecret(isRepeat, length);
		
		Settings settings = Settings.getInstance();
		settings.save(secret, length, isRepeat);
		context.setState(new PlayGame());
		context.doAction();
	}
	
	public boolean setIsRepeat() {
		int res = 0;
		Scanner in = new Scanner(System.in);
		
		do {
			try {
				System.out.print("Могут ли числа повторяться? (Введите 1 для Да, 2 для Нет): ");
				res = in.nextInt();
				
				if (res != 1 && res != 2) {
					System.out.print("Неверный ввод. Пожалуйста, введите 1 или 2: ");
				}
			} catch (InputMismatchException e) {
				System.out.print("Ошибка ввода. Пожалуйста, введите число 1 или 2: ");
				in.nextLine();
			} catch (NoSuchElementException | IllegalStateException e) {
				System.out.print("Ошибка ввода. Пожалуйста, введите число 1 или 2: ");
				in = new Scanner(System.in);
			}
		} while (res != 1 && res != 2);
		
		return res == 1;
	}
	
	public int setLength() {
		int length = 0;
		Scanner in = new Scanner(System.in);
		
		do {
			try {
				System.out.print("Введите длину загаданного числа (от 1 до 10): ");
				length = in.nextInt();
				
				if (length <= 0 || length > 10) {
					System.out.print("Длина массива должна быть от 1 до 10: ");
				}
			} catch (InputMismatchException e) {
				System.out.print("Ошибка ввода. Пожалуйста, введите число: ");
				in.nextLine();
			}
		} while (length <= 0 || length > 10);
		
		return length;
	}
	
	public int[] generateSecret(boolean isRepeat, int length) {
		int[] secret = new int[length];
		int[] used = new int[10];
		int index = 0;
		
		while(index < length) {
			int digit;
			
			digit = (int) (Math.random() * 10);
			
			if (!isRepeat && used[digit] == 0) {
				secret[index] = digit;
				used[digit]++;
				index++;
			}
			
			if(isRepeat) {
				secret[index] = digit;
				used[digit]++;
				index++;
			}
		}
		
		return secret;
	}
}
