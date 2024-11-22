package Pages.Recruitment;

import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddVacanciesPage {

    // Driver
    WebDriver addVacanciesPageDriver;

    //Locators
    By Title = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
    By vacanciesMenu = By.xpath("//a[@class='oxd-topbar-body-nav-tab-item'and contains(text(), 'Vacancies')]");
    By addNewVacancy = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By jobTitle = By.xpath("//div[./label[contains(text(), 'Job Title')]]/following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']");
    By vacancyName = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input");
    By hiringManager = By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input");
    By hiringMangerNameOption = By.xpath("//span[contains(text(),'A8DCo 4Ys 010Z')]");
    By jobTitleOption = By.xpath("//span[contains(text(), 'Account Assistant')]");
    By saveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' and @data-v-c0f2c7c8]");
    By loader = By.xpath("//div[@class='oxd-loading-spinner']");
    // Elements
    WebElement TitleElement;
    WebElement vacanciesMenuElement;
    WebElement addNewVacancyElement;
    WebElement jobTitleElement;
    WebElement vacancyNameElement;
    WebElement hiringManagerElement;
    WebElement hiringMangerNameOptionElement;
    WebElement jobTitleOptionElement;
    WebElement saveButtonElement;


    // Constructor
    public AddVacanciesPage(WebDriver driver) { addVacanciesPageDriver = driver; }


    // Methods
    public void navigateAddVacanciesPage()
    {
        // navigate to the add new vacancy
        vacanciesMenuElement = addVacanciesPageDriver.findElement(vacanciesMenu);
        Helper.click(vacanciesMenuElement);
        addNewVacancyElement = addVacanciesPageDriver.findElement(addNewVacancy);
        Helper.click(addNewVacancyElement);
    }

    private void enterVacancyName(String vacancyNameText) {
        vacancyNameElement = addVacanciesPageDriver.findElement(vacancyName);
        Helper.sendKeys(vacancyNameElement, vacancyNameText);
    }

    private void enterHiringManager(String hiringManagerText) {
        hiringManagerElement = addVacanciesPageDriver.findElement(hiringManager);
        Helper.sendKeys(hiringManagerElement, hiringManagerText);

        hiringMangerNameOptionElement = addVacanciesPageDriver.findElement(hiringMangerNameOption);
        Helper.waitForElementToBeClickable(addVacanciesPageDriver, hiringMangerNameOptionElement, 10).click();
    }

    private void selectJobTitle() {
        jobTitleElement = addVacanciesPageDriver.findElement(jobTitle);
        Helper.click(jobTitleElement);
        jobTitleOptionElement = addVacanciesPageDriver.findElement(jobTitleOption);
        Helper.waitForElementToBeClickable(addVacanciesPageDriver, jobTitleOptionElement, 10).click();
    }

    private void clickSaveButton() {
        saveButtonElement = addVacanciesPageDriver.findElement(saveButton);
        saveButtonElement.click();
    }

    public String getTitle() {
        TitleElement = addVacanciesPageDriver.findElement(Title);
        return TitleElement.getText();
    }



    public void addVacanciesPage(String vacancyNameText, String hiringManagerText) {
        selectJobTitle();
        enterVacancyName(vacancyNameText);
        enterHiringManager(hiringManagerText);
        clickSaveButton();
        Helper.waitForLoaderToDisappear(addVacanciesPageDriver, loader, 10);
    }
}
