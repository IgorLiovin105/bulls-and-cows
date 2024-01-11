package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveGameFacade {
	public static void saveGame(int[] guess) {
		String fileName = "Game.txt";
		PrintWriter writer;
		
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			
			for (int i : guess) {
				writer.print(i + " ");
			}
			
			writer.println();
			writer.close();
		} catch (IOException e) {
			System.out.println("Ошибка при записи данных в файл");
			e.printStackTrace();
		}
	}
}
