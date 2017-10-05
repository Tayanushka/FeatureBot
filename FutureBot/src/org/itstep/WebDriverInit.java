package org.itstep;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverInit {

	public static WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		chrome.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(chrome);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		waitSec(3);
		return driver;
	}

	public static void waitSec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	public static WebDriver getDriverWithLoginedAccount(Account account) {
		WebDriver driver = getWebDriver();
		driver.get("https://www.amazon.com");
		waitSec(5);
		WebElement loginElement = driver.findElement(By.id("nav-flyout-ya-signin"));
		WebElement hrefLogin = loginElement.findElement(By.tagName("a"));
		String loginLink = hrefLogin.getAttribute("href");  
		if(!loginLink.contains("https://www.amazon.com")){
			loginLink = "https://www.amazon.com" + loginLink;
		}
		driver.get(loginLink);
		waitSec(10);
		WebElement emailInput = driver.findElement(By.id("ap_email"));
		WebElement passInput = driver.findElement(By.id("ap_password"));
		WebElement submitBtn = driver.findElement(By.id("signInSubmit"));
		emailInput.sendKeys(account.getEmail());
		passInput.sendKeys(account.getPass());
		waitSec(20);
		submitBtn.submit();
		waitSec(5);
		String currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);
		waitSec(3);
		String currentPage = driver.getPageSource();
		if(currentPage.contains("Hi, "+account.getFullName())){
			return driver;
		}
		driver.get("https://www.amazon.com");
		waitSec(3);
		return driver;
	}
	
	public static WebDriver getDriverWithRegisteredAccount(Account account){
		WebDriver driver = getWebDriver();
		driver.get("https://www.amazon.com");
		waitSec(5);
		WebElement regElement = driver.findElement(By.id("nav-flyout-ya-newCust"));
		String regLink = regElement.findElement(By.tagName("a")).getAttribute("href");
		if(!regLink.contains("https://www.amazon.com")){
			regLink = "https://www.amazon.com" + regLink;
		}
		driver.get(regLink);
		waitSec(5);
		WebElement inputNameElement = driver.findElement(By.id("ap_customer_name"));
		inputNameElement.sendKeys(account.getFullName());
		WebElement inputEmailElement = driver.findElement(By.id("ap_email"));
		inputEmailElement.sendKeys(account.getEmail());
		WebElement inputPassElement = driver.findElement(By.id("ap_password"));
		inputPassElement.sendKeys(account.getPass());
		WebElement inputPassCheckElement = driver.findElement(By.id("ap_password_check"));
		inputPassCheckElement.sendKeys(account.getPass());
		waitSec(20);
		WebElement submitBtn = driver.findElement(By.id("continue"));
		submitBtn.submit();
		waitSec(5);
		String currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);
		waitSec(3);
		String currentPage = driver.getPageSource();
		if(currentPage.contains("Hi, "+account.getFullName())){
			return driver;
		}
		driver.get("https://www.amazon.com");
		waitSec(3);
		return driver;
	}

	public static void moveGood(String goodID, WebDriver driver) {
		WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
		searchInput.sendKeys(goodID);
		
		List<WebElement> webElementList = driver.findElements(By.className("nav-input"));
		for (WebElement webElement : webElementList) {
			if(webElement.getAttribute("type")!=null & webElement.getAttribute("type").equals("submit")){
				waitSec(6);
				webElement.submit();
				break;
			}
		}
		waitSec(3);
		String currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);
	}
}
