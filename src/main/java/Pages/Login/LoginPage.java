package Pages.Login;

import Pages.Dashboard.DashboardPage;
import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage
{
    // driver
    WebDriver loginDriver;

    // locators
    private By userName= By.xpath("//input[@name=\"username\"]");
    private By password= By.xpath("//input[@name=\"password\"]\n");
    private By loginButton = By.cssSelector("button[class*=\"oxd-button\"]");
    private By invalidErrorMessage = By.xpath("//p[contains(.,'credentials')]");
    private By requiredErrorMessage = By.tagName("span");
    private By dashboardText = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");

    // elements
    private WebElement userNameElement;
    private WebElement passwordElement;
    private WebElement loginButtonElement;
    private WebElement invalidErrorMessageElement;
    private WebElement requiredErrorMessageElement;
    private WebElement dashboardTextElement;

    // constructor
    public LoginPage(WebDriver driver)
    {
        this.loginDriver=driver;
    }

    // methods
    public void enterUserName(String userNameText)
    {
        Helper.wait(loginDriver,5);
        userNameElement=loginDriver.findElement(userName);
        Helper.wait(loginDriver,5);
        Helper.clear(userNameElement);
        Helper.sendKeys(userNameElement,userNameText);

    }

    public void enterPassword(String passwordText)
    {
        Helper.wait(loginDriver,5);
        passwordElement=loginDriver.findElement(password);
        Helper.clear(passwordElement);
        Helper.sendKeys(passwordElement,passwordText);
    }

    public DashboardPage clickOnLoginButton()
    {
        loginButtonElement= loginDriver.findElement(loginButton);
        Helper.click(loginButtonElement);
        return new DashboardPage(loginDriver);
    }

    public boolean isInvalidErrorMessageVisible ()
    {
        invalidErrorMessageElement=loginDriver.findElement(invalidErrorMessage);
        return invalidErrorMessageElement.isDisplayed();
    }

    public boolean isRequiredErrorMessageVisible()
    {
        requiredErrorMessageElement=loginDriver.findElement(requiredErrorMessage);
        return requiredErrorMessageElement.isDisplayed();
    }

    public boolean isDashboardTextVisible()
    {
        dashboardTextElement=loginDriver.findElement(dashboardText);
        return dashboardTextElement.isDisplayed();

    }

    public boolean isDuplicateRequiredMessageVisible()
    {
        List<WebElement> requiredErrorList =  loginDriver.findElements(requiredErrorMessage);
        for (WebElement webElement : requiredErrorList)
        {
            if (!webElement.isDisplayed())
            {
                return false;
            }
        }
        return true;
    }
}
















