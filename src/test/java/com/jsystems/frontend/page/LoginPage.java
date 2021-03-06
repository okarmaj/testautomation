package com.jsystems.frontend.page;

import com.jsystems.frontend.TestDataStatic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div#primary div.login__form-header")
    public WebElement loginHeader;
    //    public WebElement loginHeader = driver.findElement(By.cssSelector("div#primary div.login__form-header")) ;
    @FindBy(id = "usernameOrEmail")
    public WebElement usernameInput;

    @FindBy(css = "div.login__form-action button[type=\"submit\"]")
    public WebElement buttonContinue;

    @Override
    public boolean isContentPresent() {
        assertTrue(loginHeader.getText().equals(TestDataStatic.loginHeader));
        assertTrue(usernameInput.isDisplayed());
        assertTrue(buttonContinue.getText().equals(TestDataStatic.continueButton));
        assertTrue(buttonContinue.isDisplayed());
        assertTrue(buttonContinue.isEnabled());
        return true;
    }
}