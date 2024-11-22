package Pages.Leave;

import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddLeaveEntitlementPage {
    // driver
    WebDriver addLeaveEntitlementDriver;

    // locators
    By EntitlementMenu = By.xpath("//span[contains(text(), 'Entitlements ')]");
    By addEntitlementMenu = By.xpath("//a[@role='menuitem' and contains(text(), 'Add Entitlement')]");
    By addToMultipleEmployee = By.xpath("//label[./input[@value='1']]");
    By leaveType = By.xpath("//div[./label[contains(text(), 'Leave Type')]]/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']");
    By leaveOption = By.xpath("//span[contains(text(), 'CAN - FMLA')]");
    By entitlement = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input");
    By saveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' and @data-v-da722d4c]");
    By confirmButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' and @data-v-c94a08c2]");
    By message = By.xpath("//div[@id='oxd-toaster_1']/div/div");
    By messageClose = By.xpath("//div[@id='oxd-toaster_1']/div/div[@class='oxd-toast-close-container']/div");


    // Elements
    WebElement EntitlementMenuElement;
    WebElement addEntitlementMenuElement;
    WebElement addToEmployeeElement;
    WebElement leaveTypeElement;
    WebElement leaveOptionElement;
    WebElement entitlementElement;
    WebElement saveButtonElement;
    WebElement confirmButtonElement;
    WebElement messageElement;
    WebElement messageCloseElement;

    // constructor
    public AddLeaveEntitlementPage(WebDriver driver) {
        addLeaveEntitlementDriver = driver;
    }

    // methods
    public void navigateAddLeaveEntitlement()
    {
        // navigate to the add leave entitlement page
        EntitlementMenuElement = addLeaveEntitlementDriver.findElement(EntitlementMenu);
        Helper.click(EntitlementMenuElement);
        addEntitlementMenuElement = addLeaveEntitlementDriver.findElement(addEntitlementMenu);
        Helper.click(addEntitlementMenuElement);
    }


    private void selectAddToMultipleEmployee() {
        addToEmployeeElement = addLeaveEntitlementDriver.findElement(addToMultipleEmployee);
        Helper.wait(addLeaveEntitlementDriver, 5);
        addToEmployeeElement.click();
    }

    private void SelectLeaveType() {
        leaveTypeElement = addLeaveEntitlementDriver.findElement(leaveType);
        Helper.click(leaveTypeElement);
        leaveOptionElement = addLeaveEntitlementDriver.findElement(leaveOption);
        // wait for the leaveOption to be clickable
        Helper.waitForElementToBeClickable(addLeaveEntitlementDriver, leaveOptionElement, 10).click();
    }

    private void enterEntitlement(String entitlementText) {
        entitlementElement = addLeaveEntitlementDriver.findElement(entitlement);
        Helper.sendKeys(entitlementElement, entitlementText);
    }

    private void clickSaveButton() {
        saveButtonElement = addLeaveEntitlementDriver.findElement(saveButton);
        saveButtonElement.click();
    }

    private void clickConfirmButton() {
        confirmButtonElement = addLeaveEntitlementDriver.findElement(confirmButton);
        confirmButtonElement.click();
    }

    public String getMessage() {
        messageElement = addLeaveEntitlementDriver.findElement(message);
        return messageElement.getText();
    }

    public void closeMessage() {
        messageCloseElement = addLeaveEntitlementDriver.findElement(messageClose);
        messageCloseElement.click();
    }

    public void addLeaveEntitlement(String entitlementText) {
        selectAddToMultipleEmployee();
        SelectLeaveType();
        enterEntitlement(entitlementText);
        clickSaveButton();
        clickConfirmButton();
    }
}
