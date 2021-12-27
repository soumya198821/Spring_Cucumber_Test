package com.example.demo.steps;

import com.example.demo.dataSet.RunConfig;
import com.example.demo.pages.HomePage;
import com.example.demo.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefs {

    @Autowired
    private RunConfig runConfig;

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPage loginPage;

    @Before
    public void lunchApplication() throws InterruptedException {
        loginPage.navigate(runConfig.getBaseurl());
        Thread.sleep(3000);
    }

    @After
    public void closeApplication() {
        loginPage.quit();
    }

    @And("User do login to gmail application using username and password")
    public void userDoLoginToGmailApplicationUsingUsernameAndPassword() throws InterruptedException {
        loginPage.clickSignInBtn();
        loginPage.provideEmail(runConfig.getUserEmailId());
        loginPage.providePassword(runConfig.getUserPassword());
    }

    @Given("User click on email compose button")
    public void userClickOnEmailComposeButton() {
        homePage.clickComposeEmail();
    }

    @When("Use provide recipient's email subject and messageBody")
    public void useProvideRecipientSEmailSubjectAndMessageBody() {
        homePage.provideEmailDetails
                (runConfig.getRecipientEmailId(),runConfig.getUserEmailSub(),runConfig.getUserMessage());
    }

    @Then("User select send email button")
    public void userSelectSendEmailButton() {
        homePage.clickOnSendBtn();
    }

    @And("User logout from the gmail page")
    public void userLogoutFromTheGmailPage() {
        homePage.signOutOfApplication();
    }
}
