package org.example;

import java.io.*;

public class GameFileFacade {
	public static void writeToFile(int[] guess) {
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
	
	public static int[] readFromFile() {
		String fileName = "Game.txt";
		int[] guess = new int[0];
		
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String secretLine = bufferedReader.readLine();
			String[] secretValues = secretLine.split(" ");
			guess = new int[secretValues.length];
			
			for (int i = 0; i < secretValues.length; i++) {
				guess[i] = Integer.parseInt(secretValues[i]);
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("Ошибка при чтении данных из файла");
			e.printStackTrace();
		}
		
		return guess;
	}
}
