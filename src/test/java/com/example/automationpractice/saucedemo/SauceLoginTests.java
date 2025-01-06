package com.example.automationpractice.saucedemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.automationpractice.pages.SauceLoginPage;

import config.SauceGlobalVariables;

// Test of the SauceLabs demo page login
public class SauceLoginTests {
  @Test
  public void loginWithValidCredentials() {
    WebDriver driver = new ChromeDriver();

    driver.get(SauceGlobalVariables.SAUCE_BASE_URL);

    SauceLoginPage loginPage = new SauceLoginPage(driver);
    loginPage.login(SauceGlobalVariables.SAUCE_STANDARD_USER, SauceGlobalVariables.SAUCE_VALID_PASSWORD);

    String newUrl = driver.getCurrentUrl();
    Assertions.assertEquals(SauceGlobalVariables.SAUCE_INVENTORY_URL, newUrl);

    driver.quit();
  }

  @Test
  public void loginWithInvalidPassword() {
    WebDriver driver = new ChromeDriver();

    driver.get(SauceGlobalVariables.SAUCE_BASE_URL);
    
    SauceLoginPage loginPage = new SauceLoginPage(driver);
    loginPage.login(SauceGlobalVariables.SAUCE_STANDARD_USER, SauceGlobalVariables.SAUCE_INVALID_PASSWORD);

    // String newUrl = driver.getCurrentUrl();
    // Assertions.assertEquals(SauceGlobalVariables.SAUCE_INVENTORY_URL, newUrl);

    // driver.quit();
  }
}
