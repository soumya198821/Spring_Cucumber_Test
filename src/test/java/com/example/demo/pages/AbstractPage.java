package com.example.demo.pages;

import com.example.demo.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.invoke.MethodHandles;
import java.time.Duration;

public abstract class AbstractPage {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  public static final long WAIT = 40;

  public AbstractPage() {
      PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
  }

  public void navigate(final String value) {
    DriverFactory.getInstance().getDriver().manage().deleteAllCookies();
    DriverFactory.getInstance().getDriver().get(value);
    DriverFactory.getInstance().getDriver().manage().window().maximize();
  }

  protected String pageTitle() {
    return DriverFactory.getInstance().getDriver().getTitle();
  }

  protected void acceptAlert() {
    DriverFactory.getInstance().getDriver().switchTo().alert().accept();
  }

  public void waitForVisibility(WebElement element) {
    try {
      WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), WAIT);
      wait.until(ExpectedConditions.visibilityOf(element));
    } catch (TimeoutException e) {
      LOGGER.info("Element is not visible: " + e.getMessage());
      throw e;
    }
  }

  public boolean isDisplayed(WebElement element) {
    boolean isPresent = false;
    try {
      isPresent = element.isDisplayed();
      return isPresent;
    } catch (Exception e) {
      LOGGER.info("Element is not present: " + e.getMessage());
      throw e;
    }
  }

  public void clearText(WebElement element, String msg) {
    try {
      waitForVisibility(element);
      LOGGER.info(msg);
      element.clear();
    } catch (Exception e) {
      LOGGER.info("Element is not found: " + e.getMessage());
      throw e;
    }
  }

  public void enterText(WebElement element, String text, String msg) {
    try {
      waitForVisibility(element);
      clearText(element, "clear the text field");
      LOGGER.info(msg);
      element.sendKeys(text);
    } catch (Exception e) {
      LOGGER.info("Element is not found: " + e.getMessage());
      throw e;
    }
  }

  public void pressXButton(WebElement element, String msg) {
    try {
      waitForVisibility(element);
      LOGGER.info(msg);
      element.click();
    } catch (Exception e) {
      LOGGER.info("Element is not found: " + e.getMessage());
      throw e;
    }
  }
  public void scrollToElement(WebElement element){
    try{
      Actions actions = new Actions(DriverFactory.getInstance().getDriver());
      actions.moveToElement(element).perform();
    }catch (Exception e){
      LOGGER.info("not able to locate element:" + element.getText());
      throw e;
    }
  }

  public void quit() {
    DriverFactory.getInstance().getDriver().quit();
  }

  public void PoolWithFluentWait(WebElement element){
    try{
      FluentWait<WebDriver> wait = (WebDriverWait) new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver())
              .withTimeout(Duration.ofSeconds(30))
              .pollingEvery(Duration.ofSeconds(5))
              .ignoring(NoSuchElementException.class);
      wait.until(ExpectedConditions.visibilityOf(element));
    }catch (Exception e){
      LOGGER.info("not able to locate element:" + element.getText());
      throw e;
    }
  }

}
