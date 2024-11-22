package Pages.Attendance;

import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class PunchInOutPage {
    // dirver
    WebDriver punchInOutDriver;

    // locators
    By attendanceMenu = By.xpath("//span[contains(text(),'Attendance ')]");
    By punchInOut = By.xpath("//a[contains(text(),'Punch In/Out')]");
    By timeIcon = By.xpath("//i[@class='oxd-icon bi-clock oxd-time-input--clock']");
    By hourTimeArrowDown = By.xpath("//div[@class='oxd-time-hour-input']/input/following-sibling::i");
    By note = By.xpath("//textarea");
    By punchInOutButton = By.xpath("//button[@type='submit']");
    By message = By.xpath("//div[@id='oxd-toaster_1']/div/div");
    By messageClose = By.xpath("//div[@id='oxd-toaster_1']/div/div[@class='oxd-toast-close-container']/div");
    By loader = By.xpath("//div[@class='oxd-loading-spinner']");

    // elements
    WebElement attendanceMenuElement;
    WebElement punchInOutElement;
    WebElement timeIconElement;
    WebElement hourTimeArrowDownElement;
    WebElement noteElement;
    WebElement punchInOutButtonElement;
    WebElement messageElement;
    WebElement messageCloseElement;
    WebElement loaderElement;

    // constructor
    public PunchInOutPage(WebDriver driver) {
        punchInOutDriver = driver;
    }


    // methods
    public void navigateToPunchInOut(){
        attendanceMenuElement = punchInOutDriver.findElement(attendanceMenu);
        Helper.click(attendanceMenuElement);
        punchInOutElement = punchInOutDriver.findElement(punchInOut);
        Helper.click(punchInOutElement);
    }

    private void enterTime() {
        timeIconElement = punchInOutDriver.findElement(timeIcon);
        Helper.waitForElementToBeClickable(punchInOutDriver, timeIconElement, 10);
        Helper.click(timeIconElement);
    }

    private void clickArrowDown(){
        hourTimeArrowDownElement = punchInOutDriver.findElement(hourTimeArrowDown);
        Helper.waitForElementToBeClickable(punchInOutDriver, hourTimeArrowDownElement, 10);
        Helper.click(hourTimeArrowDownElement);
    }


    private void enterNote(String note){
        noteElement = punchInOutDriver.findElement(this.note);
        Helper.sendKeys(noteElement, note);
    }

    private void clickOnPunchInOutButton(){
        punchInOutButtonElement = punchInOutDriver.findElement(punchInOutButton);
        Helper.click(punchInOutButtonElement);
    }


    public String getMessage(){
        messageElement = punchInOutDriver.findElement(message);
        return messageElement.getText();
    }

    public void closeMessage(){
        messageCloseElement = punchInOutDriver.findElement(messageClose);
        Helper.click(messageCloseElement);
    }

    public void waitForLoaderToDisappear(int timeoutInSeconds){
        loaderElement = punchInOutDriver.findElement(loader);
        Helper.waitForLoaderToDisappear(punchInOutDriver, loader, timeoutInSeconds);
    }

    public void punchInOut(boolean in){
        if(in){
            enterTime();
            clickArrowDown();
        }
        enterNote("Punch In/Out");
        clickOnPunchInOutButton();
    }




}
