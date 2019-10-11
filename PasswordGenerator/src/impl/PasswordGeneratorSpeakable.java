package impl;

import java.util.ArrayList;

/**
 * Dieses Klasse soll in der lage sein aussprechbare passwörter zu generieren
 * @author thomas
 *
 */
public class PasswordGeneratorSpeakable implements PasswortGenerator {
	
	int length = 10;
	
	private String[] specialCharacters;
	private String[] digitCharacters;
	private String[] vocalCharacters;
	private String[] consonantCharacters;
	
	private int digitCount = 0;
	private int symbolsCount = 0;
	
	private ArrayList<String> signType = new ArrayList<String>();
	
	
	private PasswordGeneratorSpeakable(Builder builder) {

		// length
		if (builder.length > 0) {
			this.length = builder.length;
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
			
		}
		// symbols
		if (builder.symbols != null) {
			this.specialCharacters = builder.symbols;
			for (int i = 0; i < builder.symbolCount; i++) {
				signType.add("symbol");
			}
		}
		// not a bad practice
		// https://stackoverflow.com/questions/6086334/
		// is-it-good-practice-to-make-the-constructor-throw-an-exception
		// throw new IllegalStateException();
		
	}
	
	
	
	/*
	 * hier kann man ganz toll tdd machen
	 */
	@Override
	public String create() {	
		String result = "";
		
		for (int i = 0; i < length ; i++) {
			if (i % 2 == 0) {
				result += vocalCharacters[(int) (Math.random() * vocalCharacters.length)];
			} else {
				result += consonantCharacters[(int) (Math.random() * consonantCharacters.length)];
			}
			
		}

		return result;
	}
	
	
	
	
	
	static class Builder {
		int length;
		int digitCount;
		int symbolCount;
		String[] vocals;
		String[] consonants;
		String[] digits;
		String[] symbols;
		
		public Builder() {}
		
		public Builder length(int length) {
			this.length = length;
			return this;
		}
		
				
		public Builder vocals(String[] vocals) {
			this.vocals = vocals;
			return this;
		}
		
		public Builder consonants(String[] consonants) {
			this.consonants = consonants;
			return this;
		}
		
		public Builder digits(String[] digits, int digitCount) {
			this.digits = digits;
			return this;
		}
		
		public Builder symbols(String[] symbols, int symbolCount) {
			this.symbols = symbols;
			return this;
		}
		
		public PasswordGeneratorSpeakable build() {
			PasswordGeneratorSpeakable result = new PasswordGeneratorSpeakable(this);
			return result;
		}
		
	}
	
}
