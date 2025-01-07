package com.example.automationpractice.webdriveruniversity;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import config.GlobalVariables;

public class ClickButtonsTests {
  @Test
  public void clickXPathButton() {
    // Open button clicks page
    WebDriver driver = new ChromeDriver();
    driver.get(GlobalVariables.WDU_BASE_URL+GlobalVariables.WDU_BUTTONS_URL);

    // Click xpath button
    WebElement xpathButton = driver.findElement(By.xpath("//*[@id=\"button1\"]/p"));
    xpathButton.click();
    
    // See if popup window appears
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    WebElement modalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-title")));

    Assertions.assertTrue(modalTitle.isDisplayed());
    Assertions.assertEquals(modalTitle.getText(), "Congratulations!");
  }

  @Test
  public void clickWithJavaScript() {
    // Open button clicks page
    WebDriver driver = new ChromeDriver();
    driver.get(GlobalVariables.WDU_BASE_URL+GlobalVariables.WDU_BUTTONS_URL);

    // Click the middle button with the special javascript way
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    WebElement middleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button2")));

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", middleButton);
  }

}
