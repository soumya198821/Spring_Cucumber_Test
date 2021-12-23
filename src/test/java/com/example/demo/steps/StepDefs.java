package com.example.demo.steps;

import com.example.demo.dataSet.RunConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefs {
    WebDriver driver;
    @Autowired
    private RunConfig runConfig;

    @Given("lunch application")
    public void lunchApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get(runConfig.getBaseurl());
    }

    @And("Close application")
    public void closeApplication() {
        driver.quit();
    }
}
