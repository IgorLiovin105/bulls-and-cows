package org.example.Checks;

import org.example.GameFileFacade;
import org.example.Settings;

import java.util.HashSet;

public class Cow {
	public int countCows(int[] secret, int length) {
		int[] guess = GameFileFacade.readFromFile();
		int countOfCows = 0;
		
		HashSet<Integer> foundBullPositions = new HashSet<>();
		HashSet<Integer> foundCowPositions = new HashSet<>();
		
		for (int i = 0; i < length; i++) {
			if (guess[i] == secret[i]) {
				foundBullPositions.add(i);
			}
		}
		
		for (int i = 0; i < guess.length; i++) {
			if (!foundBullPositions.contains(i)) {
				for (int j = 0; j < length; j++) {
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

