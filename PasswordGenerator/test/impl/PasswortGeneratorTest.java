package impl;

import org.junit.Assert;
import org.junit.Test;

public class PasswortGeneratorTest {
	// ff plugin -> video download helper
	
	@Test
	public void checkPasswordLength() {
		int length = 12;
		String[] vocals = new String[]{"a","e","i"};
		
		PasswordGenerator generator = new PasswordGenerator.Builder().length(12).vocals(vocals).build();
		String passwordUnderTest = generator.create();
				
		Assert.assertEquals("Length not correct", length, passwordUnderTest.length());
		
	}
	
	@Test
	public void checkOtherPasswordLength() {
		int length = 13;
		String[] vocals = new String[]{"a","e","i"};
		
		PasswordGenerator generator = new PasswordGenerator.Builder().length(13).vocals(vocals).build();
		String passwordUnderTest = generator.create();
				
		Assert.assertEquals("Length not correct", length, passwordUnderTest.length());
	}
	
	@Test
	public void checkIfPasswordContainsAVocal() {
		int length = 12;
		
		String[] vocals = new String[]{"a","e","i"};
		
		PasswordGenerator generator = new PasswordGenerator.Builder().length(length).vocals(vocals).build();
		String passwordUnderTest = generator.create();
		
		Assert.assertTrue(passwordUnderTest.contains(vocals[0]) 
		|| passwordUnderTest.contains(vocals[1]) 
		|| passwordUnderTest.contains(vocals[2]));
		
	}
	
	
	@Test
	public void checkIfPasswordContainsASymbol() {
		int length = 12;
		
		String[] symbols = new String[]{"?","=","&","!","€"};
		
		PasswordGenerator generator = new PasswordGenerator.Builder().length(length).symbols(symbols, 2).build();
		String passwordUnderTest = generator.create();
		
		Assert.assertTrue(passwordUnderTest.contains(symbols[0]) 
		|| passwordUnderTest.contains(symbols[1]) 
		|| passwordUnderTest.contains(symbols[2]));
		
	}
	
}
