package com.example.demo.steps;

import com.example.demo.dataSet.RunConfig;
import com.example.demo.pages.HomePage;
import com.example.demo.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefs {
//    WebDriver driver;

    @Autowired
    private RunConfig runConfig;

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPage loginPage;

    @Before
    public void lunchApplication() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().deleteAllCookies();
//        driver.get(runConfig.getBaseurl());
        loginPage.navigate(runConfig.getBaseurl());
        Thread.sleep(3000);
    }

    @After
    public void closeApplication() {
        loginPage.quit();
    }

    @And("User do login to gmail application using username and password")
    public void userDoLoginToGmailApplicationUsingUsernameAndPassword() {
        loginPage.clickSignInBtn();
        loginPage.provideEmail(runConfig.getUserEmailId());
        loginPage.providePassword(runConfig.getUserPassword());
    }
}
