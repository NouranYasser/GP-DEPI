package Pages.Admin;

import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralInformationPage
{
    // Driver
    WebDriver GeneralInformationDriver;

    // Locators
    By Organization = By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent']//span[contains(text(),'Organization')]");
    By GeneralInformation = By.xpath("//a[@class='oxd-topbar-body-nav-tab-link' and contains(text(),'General Information')]");
    By EditButton = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-left']");
    By OrganizationName = By.xpath("//div[./label[normalize-space(text())='Organization Name']]/following-sibling::div/input");
    By RegistrationNumber = By.xpath("//div[./label[normalize-space(text())='Registration Number']]/following-sibling::div/input");
    By TaxID = By.xpath("//div[./label[normalize-space(text())='Tax ID']]/following-sibling::div/input");
    By Phone = By.xpath("//div[./label[normalize-space(text())='Phone']]/following-sibling::div/input");
    By Fax = By.xpath("//div[./label[normalize-space(text())='Fax']]/following-sibling::div/input");
    By Email = By.xpath("//div[./label[normalize-space(text())='Email']]/following-sibling::div/input");
    By AddressStreet1 = By.xpath("//div[./label[normalize-space(text())='Address Street 1']]/following-sibling::div/input");
    By AddressStreet2 = By.xpath("//div[./label[normalize-space(text())='Address Street 2']]/following-sibling::div/input");
    By City = By.xpath("//div[./label[normalize-space(text())='City']]/following-sibling::div/input");
    By State = By.xpath("//div[./label[normalize-space(text())='State/Province']]/following-sibling::div/input");
    By Zip = By.xpath("//div[./label[normalize-space(text())='Zip/Postal Code']]/following-sibling::div/input");
    By Country = By.xpath("//div[./label[contains(text(), 'Country')]]/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']");
    By CountryOption = By.xpath("//span[contains(text(), 'Egypt')]");
    By Notes = By.xpath("//textarea");
    By SaveButton = By.xpath("//button[@type='submit']");
    By message = By.xpath("//div[@id='oxd-toaster_1']/div/div");
    By messageClose = By.xpath("//div[@id='oxd-toaster_1']/div/div[@class='oxd-toast-close-container']/div");

    // Elements
    WebElement OrganizationElement;
    WebElement GeneralInformationElement;
    WebElement EditButtonElement;
    WebElement OrganizationNameElement;
    WebElement RegistrationNumberElement;
    WebElement TaxIDElement;
    WebElement PhoneElement;
    WebElement FaxElement;
    WebElement EmailElement;
    WebElement AddressStreet1Element;
    WebElement AddressStreet2Element;
    WebElement CityElement;
    WebElement StateElement;
    WebElement ZipElement;
    WebElement CountryElement;
    WebElement NoteElement;
    WebElement SaveButtonElement;
    WebElement messageElement;
    WebElement messageCloseElement;

    // Constructors
    public GeneralInformationPage(WebDriver driver)
    {
        GeneralInformationDriver = driver;
    }

    // Methods
    public void NavigateToGeneralInformationPage()
    {
        OrganizationElement = GeneralInformationDriver.findElement(Organization);
        Helper.click(OrganizationElement);
        GeneralInformationElement = GeneralInformationDriver.findElement(GeneralInformation);
        Helper.click(GeneralInformationElement);
    }

    private void ClickEditButton ()
    {
        EditButtonElement = GeneralInformationDriver.findElement(EditButton);
        Helper.click(EditButtonElement);
    }

    private void EnterOrganizationName(String organizationName)
    {
        OrganizationNameElement = GeneralInformationDriver.findElement(OrganizationName);
        Helper.clear(OrganizationNameElement);
        Helper.sendKeys(OrganizationNameElement, organizationName);
    }

    private void EnterRegistrationNumber(String registrationNumber)
    {
        RegistrationNumberElement = GeneralInformationDriver.findElement(RegistrationNumber);
        Helper.clear(RegistrationNumberElement);
        Helper.sendKeys(RegistrationNumberElement, registrationNumber);
    }

    private void EnterTaxID(String taxID)
    {
        TaxIDElement = GeneralInformationDriver.findElement(TaxID);
        Helper.clear(TaxIDElement);
        Helper.sendKeys(TaxIDElement, taxID);
    }

    private void EnterPhone(String phone)
    {
        PhoneElement = GeneralInformationDriver.findElement(Phone);
        Helper.clear(PhoneElement);
        Helper.sendKeys(PhoneElement, phone);
    }

    private void EnterFax(String fax)
    {
        FaxElement = GeneralInformationDriver.findElement(Fax);
        Helper.clear(FaxElement);
        Helper.sendKeys(FaxElement, fax);
    }

    private void EnterEmail(String email)
    {
        EmailElement = GeneralInformationDriver.findElement(Email);
        Helper.clear(EmailElement);
        Helper.sendKeys(EmailElement, email);
    }

    private void EnterAddressStreet1(String addressStreet1)
    {
        AddressStreet1Element = GeneralInformationDriver.findElement(AddressStreet1);
        Helper.clear(AddressStreet1Element);
        Helper.sendKeys(AddressStreet1Element, addressStreet1);
    }

    private void EnterAddressStreet2(String addressStreet2)
    {
        AddressStreet2Element = GeneralInformationDriver.findElement(AddressStreet2);
        Helper.clear(AddressStreet2Element);
        Helper.sendKeys(AddressStreet2Element, addressStreet2);
    }

    private void EnterCity(String city)
    {
        CityElement = GeneralInformationDriver.findElement(City);
        Helper.clear(CityElement);
        Helper.sendKeys(CityElement, city);
    }

    private void EnterState(String state)
    {
        StateElement = GeneralInformationDriver.findElement(State);
        Helper.clear(StateElement);
        Helper.sendKeys(StateElement, state);
    }

    private void EnterZip(String zip)
    {
        ZipElement = GeneralInformationDriver.findElement(Zip);
        Helper.clear(ZipElement);
        Helper.sendKeys(ZipElement, zip);
    }

    private void SelectCountry()
    {
        CountryElement = GeneralInformationDriver.findElement(Country);
        Helper.click(CountryElement);
        CountryElement = GeneralInformationDriver.findElement(CountryOption);
        Helper.click(CountryElement);
    }

    private void EnterNotes(String notes)
    {
        NoteElement = GeneralInformationDriver.findElement(Notes);
        Helper.clear(NoteElement);
        Helper.sendKeys(NoteElement, notes);
    }

    private void ClickSaveButton()
    {
        SaveButtonElement = GeneralInformationDriver.findElement(SaveButton);
        Helper.click(SaveButtonElement);
    }

    public String getMessage() {
        messageElement = GeneralInformationDriver.findElement(message);
        return messageElement.getText();
    }

    public void closeMessage() {
        messageCloseElement = GeneralInformationDriver.findElement(messageClose);
        Helper.click(messageCloseElement);
    }

    public void EditOrganization(String organizationName, String registrationNumber, String taxID, String phone, String fax, String email, String addressStreet1, String addressStreet2, String city, String state, String zip, String notes)
    {
        ClickEditButton();
        EnterOrganizationName(organizationName);
        EnterRegistrationNumber(registrationNumber);
        EnterTaxID(taxID);
        EnterPhone(phone);
        EnterFax(fax);
        EnterEmail(email);
        EnterAddressStreet1(addressStreet1);
        EnterAddressStreet2(addressStreet2);
        EnterCity(city);
        EnterState(state);
        EnterZip(zip);
        SelectCountry();
        EnterNotes(notes);
        ClickSaveButton();
    }

}