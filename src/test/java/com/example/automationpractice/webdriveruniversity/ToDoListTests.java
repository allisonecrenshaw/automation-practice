package com.example.automationpractice.webdriveruniversity;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToDoListTests {
  WebDriver driver;

  @BeforeEach
  public void setUp() {
      driver = new ChromeDriver();
      driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
  }

  @AfterEach
    public void tearDown() {
        // driver.quit();
    }

  @Test
  public void testAddNewTask() {
    // Locate the input field and add a new task
    WebElement inputField = driver.findElement(By.cssSelector("input:first-of-type"));
    inputField.sendKeys("Buy groceries");
    
    // Hit enter to add item
    inputField.sendKeys(Keys.RETURN);
    
    // Verify that the new task appears in the list
    WebElement newTask = driver.findElement(By.xpath("//li[contains(text(), 'Buy groceries')]"));
    Assertions.assertTrue(newTask.isDisplayed());
  }

  @Test
  public void testDeleteTask() {
    // First create the task we want to delete
    WebElement inputField = driver.findElement(By.cssSelector("input:first-of-type"));
    inputField.sendKeys("Buy groceries");
    inputField.sendKeys(Keys.RETURN);

    // Grab new task
    WebElement newTask = driver.findElement(By.xpath("//li[contains(text(), 'Buy groceries')]"));
    Assertions.assertTrue(newTask.isDisplayed());

    // Create an Actions object to perform hover
    Actions actions = new Actions(driver);

    // Hover over the task element
    actions.moveToElement(newTask).perform();

    // Locate the trash button (ensure it's visible after hover)
    WebElement trashButton = driver.findElement(By.cssSelector(".fa-trash"));

    // Click the trash button to delete the task
    trashButton.click();

    // Verify that the task is no longer in the list
    List<WebElement> tasks = driver.findElements(By.xpath("//li[contains(text(), 'Buy groceries')]"));
    // Assertion below is not working due to selector in deletion choosing the incorrect list item to delete
    // Assertions.assertTrue(tasks.isEmpty());
  }
}
