package com.example.swaglabsautomation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import config.GlobalVariables;

import com.example.swaglabsautomation.pages.LoginPage;


public class LoginTest {

  @Test
  public void loginWithValidCredentials() {
    WebDriver driver = new ChromeDriver();

    driver.get(GlobalVariables.BASE_URL);

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(GlobalVariables.STANDARD_USER, GlobalVariables.VALID_PASSWORD);

    String newUrl = driver.getCurrentUrl();
    Assertions.assertEquals(GlobalVariables.INVENTORY_URL, newUrl);

    driver.quit();
  }
}
