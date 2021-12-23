package com.example.demo.pages;

import com.example.demo.DriverFactory;
import com.example.demo.dataSet.RunConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "loginpage")
public class LoginPage extends AbstractPage{

    @FindBy(css = "div.feature__chapter__title")
    private WebElement homePageTitle;

    @FindBy(css = "a.button.button--medium.button--mobile-before-hero-only")
    private WebElement signInBtn;

    @FindBy(css = "#identifierId")
    private WebElement emailInputBox;

    @FindBy(css = "#identifierNext > div > button > span")
    private WebElement nextBtn;

    @FindBy(css = "#password")
    private WebElement passowrdInputBox;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextBtnPasswordPage;

    public void clickSignInBtn(){
        waitForVisibility(homePageTitle);
        pressXButton(signInBtn,"click signin btn");
    }

    public void provideEmail(String email){
        waitForVisibility(nextBtn);
        enterText(emailInputBox,email,"email provided");
        pressXButton(nextBtn,"next button clicked");
    }

    public void providePassword(String pwd){
        waitForVisibility(nextBtnPasswordPage);
        enterText(passowrdInputBox,pwd,"email provided");
        pressXButton(nextBtnPasswordPage,"next button clicked");
    }

}
