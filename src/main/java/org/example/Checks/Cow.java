package org.example.Checks;

import org.example.GameFileFacade;
import org.example.Settings;

import java.util.HashSet;

public class Cow {
	private int length;
	private int[] secret;
	private int[] guess;
	
	public Cow() {
		guess = GameFileFacade.readFromFile();
		length = Settings.getInstance().getLength();
		secret = Settings.getInstance().getSecret();
	}
	
	public int countCows() {
		int countOfCows = 0;
		HashSet<Integer> foundBullPositions = new HashSet<>();
		HashSet<Integer> foundCowPositions = new HashSet<>();
		
		for (int i = 0; i < guess.length; i++) {
			if (guess[i] == secret[i]) {
				foundBullPositions.add(i);
			}
		}
		
		for (int i = 0; i < guess.length; i++) {
			if (!foundBullPositions.contains(i)) {
				for (int j = 0; j < secret.length; j++) {
					if (guess[i] == secret[j] && !foundBullPositions.contains(j) && !foundCowPositions.contains(j)) {
						countOfCows++;
						foundCowPositions.add(j);
						break;
					}
				}
			}
		}
		return countOfCows;
	}
}
