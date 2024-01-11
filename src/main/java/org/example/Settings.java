package org.example;

import java.util.Arrays;

public class Settings {
	private static Settings settings;
	private int[] secret;
	private int length;
	private boolean isRepeat;
	
	public static Settings getInstance() {
		if(settings == null) {
			settings = new Settings();
		}
		
		return settings;
	}
	
	public void save(int[] secret, int length, boolean isRepeat) {
		this.secret = secret;
		this.length = length;
		this.isRepeat = isRepeat;
	}
	
	public String showSettings() {
		String res = "Загаданное число: " + Arrays.toString(this.secret) + "; Длина числа: " + this.length + "; Повторяющиеся числа: " + this.isRepeat + ";";
		System.out.println(res);
		return res;
	}
	public int[] getSecret() {
		return this.secret;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public boolean getIsRepeat() {
		return this.isRepeat;
	}
}
