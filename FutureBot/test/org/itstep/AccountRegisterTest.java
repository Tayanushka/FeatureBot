package org.itstep;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AccountRegisterTest {

	@Test
	public void testNewAccountRegistration() {
		FileIO fileIO = new FileIO();
		String textFromFile = fileIO.readFromFile("D://accountList.txt");
		String[] lines = textFromFile.split("/n");
		ArrayList<Account> accounts = new ArrayList<>();
		for(int i=0; i<lines.length; i++){
			String[] words = lines[i].split(" ");
			Account account = new Account(words[0], words[1], words[2]);
			accounts.add(account);
		}
		if(!accounts.isEmpty()){
			Account registeredAccount = WebDriverInit.getRegisteredAccount(accounts.get(0));
			assertEquals(registeredAccount.getEmail(), accounts.get(0).getEmail());
		}
		
	}

}
