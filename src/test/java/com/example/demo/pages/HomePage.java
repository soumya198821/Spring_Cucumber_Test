package com.example.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "homepage")
public class HomePage extends AbstractPage{

    @FindBy(xpath = "//a[@title='Gmail']/img")
    private WebElement gmailImage;

    @FindBy(xpath = "//div[@role='button']/text()")
    private WebElement composeBtn;

    @FindBy(xpath = "//textarea[@role='combobox']")
    private WebElement receiverMailBox;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subject;

    @FindBy(xpath = "//*[@role='textbox']")
    private WebElement msgBody;

    @FindBy(xpath = "//*[text()='Send']")
    private WebElement sendBtn;

    @FindBy(xpath = " //a[@role='button']/img")
    private WebElement imageIocnForLogout;

    @FindBy(xpath = "//a[text()='Sign out of all accounts']")
    private WebElement signoutBtn;

    public void clickComposeEmail(){

    }

    public void provideEmailDetails(String toEmail,String sub, String messageBody){

    }

    public void clickOnSendBtn(){

    }

    public void signOutOfApplication(){

    }
}
