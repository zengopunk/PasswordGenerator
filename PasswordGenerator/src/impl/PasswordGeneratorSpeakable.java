package impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Dieses Klasse soll in der lage sein aussprechbare passwörter zu generieren
 * @author thomas
 *
 */
public class PasswordGeneratorSpeakable implements PasswordGenerator {
	
	int newPasswordLength = 10;
	
	private char[] specialCharacters;
	private char[] digitCharacters;
	private char[] vocalCharacters;
	private char[] consonantCharacters;
	
	private int digitCount = 0;
	private int symbolsCount = 0;
	
	private ArrayList<String> signType = new ArrayList<String>();
	
	
	private PasswordGeneratorSpeakable(Builder builder) {

		// length
		if (builder.length > 0) {
			this.newPasswordLength = builder.length;
		}
		
		// vocals 
		if (builder.vocals == null) {
			this.vocalCharacters = VOCALS;
		} else {
			this.vocalCharacters = builder.vocals;
		}
		// consonants
		if (builder.consonants == null) {
			this.consonantCharacters = CONSONANTS;
		} else {
			this.consonantCharacters = builder.consonants;
		}
		// digits
		if (builder.digits != null) {
			this.digitCharacters = builder.digits;
			for (int i = 0; i < builder.digitCount; i++) {
				signType.add("digit");
			}
			this.digitCount = builder.digitCount;
			
		}
		// symbols
		if (builder.symbols != null) {
			this.specialCharacters = builder.symbols;
			for (int i = 0; i < builder.symbolCount; i++) {
				signType.add("symbol");
			}
			this.symbolsCount = builder.symbolCount;
		}
		// not a bad practice
		// https://stackoverflow.com/questions/6086334/
		// is-it-good-practice-to-make-the-constructor-throw-an-exception
		// throw new IllegalStateException();
		
	}
	
	
	
	@Override
	public String create() {	
		char[] result = new char[newPasswordLength];
		
		int counter = 0;
		
		while (counter < newPasswordLength) {
			if (counter % 2 == 0) {
				result[counter] = vocalCharacters[(int)(Math.random() * vocalCharacters.length)];
			} else {
				result[counter] = consonantCharacters[(int) (Math.random() * consonantCharacters.length)];
			}
								
			counter++;
		}
		
		List<Integer> randPositions = new ArrayList<>();
		// digitCharacters
		if (digitCharacters != null) {
			for (int i = 0; i < digitCount; i++) {
				char randomDigit = digitCharacters[(int) (Math.random() * digitCharacters.length)];
				int randArrayPosition = (int)(Math.random() * newPasswordLength);
				
				while (randPositions.contains(randArrayPosition)) {
					randArrayPosition = (int)(Math.random() * newPasswordLength);
				}
				
				randPositions.add(randArrayPosition);
				
				result[randArrayPosition] = randomDigit;
				
				
			}
		}
		
		
		randPositions = new ArrayList<>();
		// specialCharacters
		if (specialCharacters != null) {
			for (int i = 0; i < symbolsCount; i++) {
				char randomSymbol = specialCharacters[(int) (Math.random() * specialCharacters.length)];
				int randArrayPosition = (int)(Math.random() * newPasswordLength);
				
				while (randPositions.contains(randArrayPosition)) {
					randArrayPosition = (int)(Math.random() * newPasswordLength);
				}
				
				randPositions.add(randArrayPosition);
				
				result[randArrayPosition] = randomSymbol;
				
			}
		}

		return new String(result);
	}
	
	
	public static void main(String[] args) {
		PasswordGeneratorSpeakable passwordGeneratorSpeakable = new PasswordGeneratorSpeakable.Builder().length(16).digits(new char[]{'1','0','3'},2).symbols(new char[] {'$','€'}, 2).build();
		String newPassword = passwordGeneratorSpeakable.create();
		System.out.println(newPassword);
	}
	
	/*
	 * Bilder Klasse um PasswordGerator zu konfigurieren. Anwendung des Builder Pattern 
	 */
	static public class Builder {
		private int length;
		private int digitCount;
		private int symbolCount;
		private char[] vocals;
		private char[] consonants;
		private char[] digits;
		private char[] symbols;
		
		public Builder() {}
		
		public Builder length(int length) {
			this.length = length;
			return this;
		}
		
				
		public Builder vocals(char[] vocals) {
			this.vocals = vocals;
			return this;
		}
		
		public Builder consonants(char[] consonants) {
			this.consonants = consonants;
			return this;
		}
		
		public Builder digits(char[] digits, int digitCount) {
			this.digits = digits;
			this.digitCount = digitCount;
			return this;
		}
		
		public Builder symbols(char[] symbols, int symbolCount) {
			this.symbols = symbols;
			this.symbolCount = symbolCount;
			return this;
		}
		
		public PasswordGeneratorSpeakable build() {
			PasswordGeneratorSpeakable result = new PasswordGeneratorSpeakable(this);
			return result;
		}
		
	}
	
}
