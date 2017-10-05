package org.itstep;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountCreatorTest {

	@Test
	public void testGetRandomNumber() {
		AccountCreator accCreator = new AccountCreator();
		int rndNumber = accCreator.getRandomNumber(10, 20);
		assertTrue(rndNumber>=10 && rndNumber<=20);
	}

	@Test
	public void testGetRandomString() {
		AccountCreator accCreator = new AccountCreator();
		String rndString = accCreator.getRandomString(accCreator.getRandomNumber(10, 20));
		assertTrue(rndString.length()>=10 && rndString.length()<=20);	
	}
	
	@Test
	public void testGetRandomEmail() {
		AccountCreator accCreator = new AccountCreator();
		String rndString = accCreator.getRandomString(accCreator.getRandomNumber(10, 20));
		String rndEmail = accCreator.getRandomEmail(rndString, accCreator.getRandomNumber(1, 5));
		assertTrue(rndEmail.contains(rndString));
		assertTrue(rndEmail.contains("@"));
	}
	
	@Test
	public void testGetRandomPass() {
		AccountCreator accCreator = new AccountCreator();
		String rndPass = accCreator.getRandomPass();
		assertEquals(10, rndPass.length());
		char[] symbols = rndPass.toCharArray();
		for(int i = 6; i<=9; i++){
			assertTrue(Character.isDigit(symbols[i]));
		}
	}
	
	@Test
	public void testGetRandomAccount() {
		AccountCreator accCreator = new AccountCreator();
		Account account = accCreator.getRandomAccount();
		assertTrue(account.getFullName().length()>=8 && account.getFullName().length()<=14);
		assertTrue(account.getEmail().contains(account.getFullName()));
		assertTrue(account.getEmail().contains("@"));
		assertEquals(10, account.getPass().length());
		char[] symbols = account.getPass().toCharArray();
		for(int i = 6; i<=9; i++){
			assertTrue(Character.isDigit(symbols[i]));
		}
	}
}
