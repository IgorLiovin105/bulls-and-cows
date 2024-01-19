package org.example;

import java.util.Arrays;

public class Settings {
	private static Settings settings;
	public int[] secret;
	public int length;
	public boolean isRepeat;
	
	public static Settings getInstance() {
		if (settings == null) {
			settings = new Settings();
		}
		
		return settings;
	}
	
	public void save(int[] secret, int length, boolean isRepeat) {
		this.secret = secret;
		this.length = length;
		this.isRepeat = isRepeat;
	}
}

