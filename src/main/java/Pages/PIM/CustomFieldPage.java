package Pages.PIM;

import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomFieldPage {

    WebDriver CustomFieldDriver;

    By CustomerField = By.xpath("//a[contains(text(),\"Custom Fields\")]");
    By ConfigurationMenu = By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']");

    By AddButton =By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']") ;
    By FieldName = By.xpath("//div[@class='oxd-input-group__label-wrapper']/following-sibling::div/input");
    By Screen = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div");

    By Type = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div");
    By SaveButton = By.xpath("//button[@type='submit']");

    By ScreenOption = By.xpath("//span[contains(text(), 'Personal Details')]");

    By TypeOption = By.xpath("//span[contains(text(), 'Text or Number')]");
    By message = By.xpath("//div[@id='oxd-toaster_1']/div/div");
    By messageClose = By.xpath("//div[@id='oxd-toaster_1']/div/div[@class='oxd-toast-close-container']/div");
    By DeleteButton = By.xpath("//i[@class='oxd-icon bi-trash']");

    By YesDeleteButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");

    WebElement DeleteButtonElement;
    WebElement YesDeleteButtonElement;
    WebElement ScreenOptionElement;
    WebElement TypeOptionElement;
    WebElement ConfigurationMenuElement;
    WebElement CustomerFieldElement;

    WebElement SaveButtonElement;
    WebElement AddButtonElement;
    WebElement FieldNameElement;
    WebElement TypeElement;
    WebElement ScreenElement;
    WebElement messageElement;
    WebElement messageCloseElement;


    public CustomFieldPage(WebDriver driver) {
        CustomFieldDriver = driver;
    }

    public void NavigateToCustomField() {
        ConfigurationMenuElement = CustomFieldDriver.findElement(ConfigurationMenu);
        Helper.click(ConfigurationMenuElement);
        CustomerFieldElement = CustomFieldDriver.findElement(CustomerField);
        Helper.click(CustomerFieldElement);
    }

    public void NavigateToAddCustomField() {
        NavigateToCustomField();
        AddButtonElement = CustomFieldDriver.findElement(AddButton);
        Helper.click(AddButtonElement);
    }

    public void addFieldName(String fieldName) {
        CustomFieldDriver.findElement(FieldName).sendKeys(fieldName);
    }

    public void selectScreen() {

        CustomFieldDriver.findElement(Screen).click();
        ScreenOptionElement = CustomFieldDriver.findElement(ScreenOption);
        Helper.click(ScreenOptionElement);

    }

    public void selectType() {
        CustomFieldDriver.findElement(Type).click();
        TypeOptionElement = CustomFieldDriver.findElement(TypeOption);
        Helper.click(TypeOptionElement);
    }
    public void saveCustomField() {

        CustomFieldDriver.findElement(SaveButton).click();
    }
    public String getMessage() {
        messageElement = CustomFieldDriver.findElement(message) ;
        return messageElement.getText();
    }

    public void closeMessage() {
        messageCloseElement = CustomFieldDriver.findElement(messageClose);
        messageCloseElement.click();
    }
    public void addCustomField(String fieldName)
    {
        addFieldName(fieldName);
        selectScreen();
        selectType();
        saveCustomField();
    }

    public void deleteCustomField()
    {
        DeleteButtonElement = CustomFieldDriver.findElement(DeleteButton);
        Helper.click(DeleteButtonElement);
        YesDeleteButtonElement = CustomFieldDriver.findElement(YesDeleteButton);
        Helper.click(YesDeleteButtonElement);

    }

}
