package com.example.demo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "homepage")
public class HomePage extends AbstractPage{

    @FindBy(xpath = "//a[@title='Gmail']/img")
    private WebElement gmailImage;

    @FindBy(xpath = "//*[text()='Compose']")
    private WebElement composeBtn;

    @FindBy(xpath = "//*[@name='to']")
    private WebElement receiverMailBox;

    @FindBy(xpath = "//*[@name='subjectbox']")
    private WebElement subject;

    @FindBy(xpath = "//*[@aria-label='Message Body' and @role='textbox']")
    private WebElement msgBody;

    @FindBy(xpath = "//*[contains(@aria-label,'Send') and @data-tooltip]")
    private WebElement sendBtn;

    @FindBy(xpath = "//*[text()='Message sent']")
    private WebElement msgSent;

    @FindBy(xpath = " //a[@role='button']/img")
    private WebElement imageIocnForLogout;

    @FindBy(xpath = "//a[text()='Sign out of all accounts']")
    private WebElement signoutBtn;

    public void clickComposeEmail(){
        waitForVisibility(gmailImage);
        isDisplayed(gmailImage);
        pressXButton(composeBtn,"click on compose btn");
    }

    public void provideEmailDetails(String toEmail,String sub, String messageBody){
        waitForVisibility(sendBtn);
        isDisplayed(receiverMailBox);
        enterText(receiverMailBox,toEmail,"providing recipients email ");
        enterText(subject,sub,"providing mail subject");
        enterText(msgBody,messageBody,"providing mail details");
    }

    public void clickOnSendBtn(){
        pressXButton(sendBtn,"click on send button");
        waitForVisibility(msgSent);
        Assert.assertEquals("Validate message sent success msg : ","Message sent",msgSent.getText());
    }

    public void signOutOfApplication(){
        pressXButton(imageIocnForLogout,"");
        scrollToElement(signoutBtn);
        pressXButton(signoutBtn,"");
    }
}
