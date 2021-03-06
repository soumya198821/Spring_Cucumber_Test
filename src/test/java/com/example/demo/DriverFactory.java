package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

  private DriverFactory() {
    // Do-nothing..Do not allow to initialize this class from outside
  }

  private static DriverFactory instance = new DriverFactory();

  public static DriverFactory getInstance() {
    return instance;
  }

  // thread local driver object for webdriver
  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
    @Override
    protected WebDriver initialValue() {
      WebDriverManager.chromedriver().setup();
      return new ChromeDriver();
    }
  };

  // call this method to get the driver object and launch the browser
  public WebDriver getDriver() {
    return driver.get();
  }

  // Quits the driver and closes the browser
  public void removeDriver() {
    driver.get().quit();
    driver.remove();
  }
}
