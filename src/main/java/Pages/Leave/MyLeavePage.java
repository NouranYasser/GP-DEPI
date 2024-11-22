package Pages.Leave;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MyLeavePage {
    // driver
    WebDriver myLeaveDriver;

    // locators
    By myLeaveMenu = By.xpath("//a[contains(text(),'My Leave')]");
    By leaveType = By.xpath("//div[./label[contains(text(), 'Leave Type')]]/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']");
    By leaveOption = By.xpath("//span[contains(text(), 'CAN - FMLA')]");
    String[] status = {"Rejected ", "Cancelled ", "Scheduled ", "Taken " };
    By removeStatusButton = By.xpath("//span[contains(text(), '" + status[0] + "')]/i");
    By searchButton = By.xpath("//button[@type='submit']");
    By cancelButton = By.xpath("//div[./div[contains(text(),'Leave for vacation')]]/following-sibling::div/div/button");
    By message = By.xpath("//div[@id='oxd-toaster_1']/div/div");
    By messageClose = By.xpath("//div[@id='oxd-toaster_1']/div/div[@class='oxd-toast-close-container']/div");


    // Elements
    WebElement myLeaveMenuElement;
    WebElement leaveTypeElement;
    WebElement leaveOptionElement;
    WebElement removeStatusButtonElement;
    WebElement searchButtonElement;
    WebElement cancelButtonElement;
    WebElement messageElement;
    WebElement messageCloseElement;
    
    // constructor
    public MyLeavePage(WebDriver driver) {
        myLeaveDriver = driver;
    }
    
    // methods
    public void navigateMyLeave() {
        myLeaveMenuElement = myLeaveDriver.findElement(myLeaveMenu);
        myLeaveMenuElement.click();
    }

    private void SelectLeaveType() {
        leaveTypeElement = myLeaveDriver.findElement(leaveType);
        leaveTypeElement.click();
        leaveOptionElement = myLeaveDriver.findElement(leaveOption);
        leaveOptionElement.click();
    }
    // function to return the By locator for the status given i
    private By removeStatusButton(int i) {
        return By.xpath("//span[contains(text(),'" + status[i] + "')]/i");
    }

    public void searchByStatus() {
        for (int i = 0; i < status.length; i++) {
            removeStatusButton = removeStatusButton(i);
            removeStatusButtonElement = myLeaveDriver.findElement(removeStatusButton);
            removeStatusButtonElement.click();
        }
    }

    private void clickSearchButton() {
        searchButtonElement = myLeaveDriver.findElement(searchButton);
        searchButtonElement.click();
    }

    private void clickCancelButton() {
        cancelButtonElement = myLeaveDriver.findElement(cancelButton);
        cancelButtonElement.click();
    }

    public String getMessage() {
        messageElement = myLeaveDriver.findElement(message);
        return messageElement.getText();
    }

    public void closeMessage() {
        messageCloseElement = myLeaveDriver.findElement(messageClose);
        messageCloseElement.click();
    }

    public void cancelLeave() {
        SelectLeaveType();
        searchByStatus();
        clickSearchButton();
        clickCancelButton();
    }

}
