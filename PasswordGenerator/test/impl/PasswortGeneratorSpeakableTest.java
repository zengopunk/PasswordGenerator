package impl;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PasswortGeneratorSpeakableTest {
	// ff plugin -> video download helper
	
	@Test
	public void checkPasswordLength() {
		int length = 12;
		char[] vocals = new char[]{'a','e','i'};
		
		PasswordGeneratorSpeakable generator = new PasswordGeneratorSpeakable.Builder().length(12).vocals(vocals).build();
		String passwordUnderTest = generator.create();
				
		Assert.assertEquals("Length not correct", length, passwordUnderTest.length());
		
	}
	
	@Test
	public void checkOtherPasswordLength() {
		int length = 13;
		char[] vocals = new char[]{'a','e','i'};
		
		PasswordGeneratorSpeakable generator = new PasswordGeneratorSpeakable.Builder().length(13).vocals(vocals).build();
		String passwordUnderTest = generator.create();
				
		Assert.assertEquals("Length not correct", length, passwordUnderTest.length());
	}
	
	@Test
	public void checkIfPasswordContainsAVocal() {
		int length = 12;
		
		char[] vocals = new char[]{'a','e','i'};
		
		PasswordGeneratorSpeakable generator = new PasswordGeneratorSpeakable.Builder().length(length).vocals(vocals).build();
		String passwordUnderTest = generator.create();
		
		
		
		Assert.assertTrue((Arrays.binarySearch(passwordUnderTest.toCharArray(), vocals[0]) != -1) 
		|| (Arrays.binarySearch(passwordUnderTest.toCharArray(), vocals[1]) != -1) 
		||(Arrays.binarySearch(passwordUnderTest.toCharArray(), vocals[2]) != -1));
		
	}
	
	
	
	
}
