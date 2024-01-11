package org.example.Checks;

import org.example.GameFileFacade;
import org.example.Settings;

public class Bull {
	private int length;
	private int[] secret;
	private int[] guess;
	
	public Bull() {
		guess = GameFileFacade.readFromFile();
		length = Settings.getInstance().getLength();
		secret = Settings.getInstance().getSecret();
	}
	
	public int countBulls() {
		int countOfBulls = 0;
		int[] usedGuess = new int[10];
		
		for (int i = 0; i < length; i++) {
			if (secret[i] == guess[i]) {
				countOfBulls++;
				usedGuess[guess[i]]--;
			}
		}
		
		return countOfBulls;
	}
}
