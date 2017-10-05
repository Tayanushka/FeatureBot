package org.itstep;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class WebDriverInitTest {

	@Test
	public void testWebDriver() {
		WebDriver driver = WebDriverInit.getWebDriver();
		assertNotNull(driver);	
		driver.close();
	}
}
