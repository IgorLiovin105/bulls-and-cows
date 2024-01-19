package org.example.Checks;

import org.example.GameFileFacade;
import org.example.Settings;

public class Bull {
	public int countBulls(int[] secret, int length) {
		int[] guess = GameFileFacade.readFromFile();
		int countOfBulls = 0;
		
		for (int i = 0; i < length; i++) {
			if (secret[i] == guess[i]) {
				countOfBulls++;
			}
		}
		
		return countOfBulls;
	}
}

