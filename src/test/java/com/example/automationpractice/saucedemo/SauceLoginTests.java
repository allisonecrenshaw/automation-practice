package com.example.automationpractice.saucedemo;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    WebElement errorMessageContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message-container.error")));
    String errorMessage = errorMessageContainer.getText();
    
    String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

    Assertions.assertTrue(errorMessageContainer.isDisplayed());
    Assertions.assertEquals(errorMessage, expectedErrorMessage);
    
    String currentUrl = driver.getCurrentUrl();
    Assertions.assertEquals(SauceGlobalVariables.SAUCE_BASE_URL, currentUrl);

    driver.quit();
  }
}
