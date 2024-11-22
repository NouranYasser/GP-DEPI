package Pages.PIM;

import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeePage {

    WebDriver EmployeeDriver;
    By AddEmployeeList = By.xpath("//a[contains(text(), 'Add Employee')]");

    By Title = By.xpath("//h6[@class= 'oxd-text oxd-text--h6 orangehrm-main-title']");
    By FirstName = By.xpath("//input[@name='firstName']");
    By MiddleName = By.xpath("//input[@name='middleName']");
    By LastName = By.xpath("//input[@name='lastName']");
    By CreateLoginDetailsButton = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']");

    By UserName = By.xpath("//div[./label[normalize-space(text())='Username']]/following-sibling::div/input");
    By Password = By.xpath("//div[./label[normalize-space(text())='Password']]/following-sibling::div/input");
    By ConfirmPassword = By.xpath("//div[./label[normalize-space(text())='Confirm Password']]/following-sibling::div/input");
    By SaveButton = By.xpath("//button[@type='submit']");
    By message = By.xpath("//div[@id='oxd-toaster_1']/div/div");
    By messageClose = By.xpath("//div[@id='oxd-toaster_1']/div/div[@class='oxd-toast-close-container']/div");

    WebElement FirstNameElement ;
    WebElement MiddleNameElement ;
    WebElement LastNameElement ;
    WebElement UserNameElement ;
    WebElement PasswordElement ;
    WebElement ConfirmPasswordElement ;
    WebElement messageElement;
    WebElement messageCloseElement;
    WebElement TitleElement ;

    public EmployeePage(WebDriver driver) {
        EmployeeDriver = driver;
    }

    public String getPageTitle(){
        TitleElement = EmployeeDriver.findElement(Title);
        return TitleElement.getText();
    }


    public void EnterFirstName(String FirstName) {

        FirstNameElement = EmployeeDriver.findElement(this.FirstName);
        Helper.sendKeys(FirstNameElement, FirstName);
    }

    public void EnterMiddleName(String MiddleName) {

        MiddleNameElement = EmployeeDriver.findElement(this.MiddleName);
        Helper.sendKeys(MiddleNameElement, MiddleName);

    }

    public void EnterLastName(String LastName) {

        LastNameElement = EmployeeDriver.findElement(this.LastName);
        Helper.sendKeys(LastNameElement , LastName);

    }

    public void CreateLoginDetails() {
        Helper.click(EmployeeDriver.findElement(CreateLoginDetailsButton));
    }

    public void EnterUserName(String UserName) {
        UserNameElement = EmployeeDriver.findElement(this.UserName);
        Helper.sendKeys(UserNameElement, UserName);
    }

    public void EnterPassword(String Password) {
        PasswordElement = EmployeeDriver.findElement(this.Password);
        Helper.sendKeys(PasswordElement, Password);
    }

    public void EnterConfirmPassword(String ConfirmPassword) {
        ConfirmPasswordElement = EmployeeDriver.findElement(this.ConfirmPassword);
        Helper.sendKeys(ConfirmPasswordElement, ConfirmPassword);
    }

    public void SaveEmployee() {
        Helper.click(EmployeeDriver.findElement(SaveButton));
    }

    public String getMessage() {
        messageElement = EmployeeDriver.findElement(message);
        return messageElement.getText();
    }

    public void closeMessage() {
        messageCloseElement = EmployeeDriver.findElement(messageClose);
        messageCloseElement.click();
    }

    public void NavigateToAddEmployee(){
        Helper.click(EmployeeDriver.findElement(AddEmployeeList));
    }

    public void AddEmployee(String FirstName, String MiddleName, String LastName , String Username , String Password , String ConfirmPassword){
        EnterFirstName(FirstName);
        EnterMiddleName(MiddleName);
        EnterLastName(LastName);
        CreateLoginDetails();
        EnterUserName(Username);
        EnterPassword(Password);
        EnterConfirmPassword(ConfirmPassword);
        SaveEmployee();
    }



}
