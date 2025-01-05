package com.example.swaglabsautomation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import config.GlobalVariables;

public class LoginTest {

  @Test
  public void successfulLogin() {
    WebDriver driver = new ChromeDriver();

    driver.get(GlobalVariables.BASE_URL);

    driver.quit();
  }
}
