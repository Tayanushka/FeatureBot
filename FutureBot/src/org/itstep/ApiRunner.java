package org.itstep;

import org.openqa.selenium.WebDriver;

public class ApiRunner {

	public static void main(String[] args) {

		String goodID = "";
		
		AccountCreator accCreator = new AccountCreator();
		Account account = accCreator.getRandomAccount();
		boolean isNotRegistered = true;
		boolean isNotLogined = true;
		WebDriver driver = WebDriverInit.getDriverWithLoginedAccount(account);
		if (driver.getPageSource().contains("Hi, " + account.getFullName())) {
			isNotLogined = false;
		}
		driver.quit();
		if (isNotLogined) {
			WebDriverInit.waitSec(5);
			int count = 0;
			while (isNotRegistered) {
				count++;
				driver = WebDriverInit.getDriverWithRegisteredAccount(account);
				if (driver.getPageSource().contains("Hi, " + account.getFullName())) {
					isNotRegistered = false;
				}
				if (count > 3) {
					isNotRegistered = true;
					System.out.println("Something wrong!");
					driver.quit();
					break;
				}
			}
//			driver.quit();
		}
		if (!isNotRegistered) {
			FileIO fileIO = new FileIO();
			String textToWrite = account.getEmail() + " " + account.getPass() + " " + account.getFullName() + "\n";
			fileIO.writeToFile(textToWrite, "D://accountList.txt");
			
			WebDriverInit.moveGood(goodID, driver);
		}
		
		
	}
}
