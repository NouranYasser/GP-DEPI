package Pages.Leave;


import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ApplyPage {
    // Driver
    WebDriver applyDriver;

    // Locators
    By applyMenu = By.xpath("//a[contains(text(),'Apply')]");
    By leaveType = By.xpath("//div[./label[contains(text(), 'Leave Type')]]/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']");
    By leaveOption = By.xpath("//span[contains(text(), 'CAN - FMLA')]");
    By fromDate = By.xpath("//div[./label[contains(text(), 'From Date')]]/following-sibling::div//div/input");
    By toDate = By.xpath("//div[./label[contains(text(), 'To Date')]]/following-sibling::div//div/input");
    By toDateIcon = By.xpath("//div[./label[contains(text(), 'To Date')]]/following-sibling::div//div/i");
    By partialDays = By.xpath("//div[./label[contains(text(), 'Partial Days')]]/following-sibling::div//div[@class='oxd-select-wrapper']");
    By partialDaysOption = By.xpath("//span[contains(text(), 'All Days')]");
    By duration = By.xpath("//div[./label[contains(text(), 'Duration')]]/following-sibling::div//div/div[@class='oxd-select-text-input']");
    By durationOption = By.xpath("//span[contains(text(), 'Specify Time')]");
    By comment = By.xpath("//textarea");
    By applyButton = By.xpath("//button[@type='submit']");
    By message = By.xpath("//div[@id='oxd-toaster_1']/div/div");
    By messageClose = By.xpath("//div[@id='oxd-toaster_1']/div/div[@class='oxd-toast-close-container']/div");


    // Elements
    WebElement applyMenuElement;
    WebElement leaveTypeElement;
    WebElement leaveOptionElement;
    WebElement fromDateElement;
    WebElement toDateElement;
    WebElement toDateIconElement;
    WebElement partialDaysElement;
    WebElement partialDaysOptionElement;
    WebElement durationElement;
    WebElement durationOptionElement;
    WebElement commentElement;
    WebElement applyButtonElement;
    WebElement messageElement;
    WebElement messageCloseElement;


    // Constructor
    public ApplyPage(WebDriver driver) {
        applyDriver = driver;
    }

    // Methods
    public void navigateApplyLeave()
    {
        // navigate to the apply leave page
        applyMenuElement = applyDriver.findElement(applyMenu);
        Helper.click(applyMenuElement);
    }

    private void SelectLeaveType() {
        leaveTypeElement = applyDriver.findElement(leaveType);
        Helper.click(leaveTypeElement);
        leaveOptionElement = applyDriver.findElement(leaveOption);
        // wait for the leaveOption to be clickable
        Helper.waitForElementToBeClickable(applyDriver, leaveOptionElement, 10).click();

    }

    // format yyyy-dd-mm
    private void SetFromDate(String date) {
        fromDateElement = applyDriver.findElement(fromDate);
        Helper.sendKeys(fromDateElement, date);
    }

    // format yyyy-dd-mm
    private void SetToDate(String date){
        toDateElement = applyDriver.findElement(toDate);
        Helper.clear(toDateElement);
        Helper.sendKeys(toDateElement, date);
        toDateIconElement = applyDriver.findElement(toDateIcon);
        Helper.click(toDateIconElement);

    }

    private void SelectPartialDays() {
        partialDaysElement = applyDriver.findElement(partialDays);
        Helper.click(partialDaysElement);

        partialDaysOptionElement = applyDriver.findElement(partialDaysOption);
        // wait for the partialDaysOption to be clickable
        Helper.waitForElementToBeClickable(applyDriver, partialDaysOptionElement, 10).click();

    }

    private void SelectDuration() {
        durationElement = applyDriver.findElement(duration);
        Helper.click(durationElement);
        durationOptionElement = applyDriver.findElement(durationOption);
        // wait for the durationOption to be clickable
        Helper.waitForElementToBeClickable(applyDriver, durationOptionElement, 10).click();
    }

    private void SetComment(String commentText) {
        commentElement = applyDriver.findElement(comment);
        Helper.sendKeys(commentElement, commentText);
    }

    private void ClickApply() {
        applyButtonElement = applyDriver.findElement(applyButton);
        Helper.click(applyButtonElement);
    }

    public String getMessage() {
        messageElement = applyDriver.findElement(message);
        return messageElement.getText();
    }

    public void closeMessage() {
        messageCloseElement = applyDriver.findElement(messageClose);
        Helper.click(messageCloseElement);
    }


    public void ApplyLeave(String fromDate, String toDate, String comment) {
        SelectLeaveType();
        SetFromDate(fromDate);
        SetToDate(toDate);
        SelectPartialDays();
        SelectDuration();
        SetComment(comment);
        ClickApply();
    }
}
