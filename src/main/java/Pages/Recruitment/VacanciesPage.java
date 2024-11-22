package Pages.Recruitment;

import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VacanciesPage {

    //Driver
    WebDriver vacanciesPageDriver;


    //Locators
    By viewNavTab = By.xpath("//li[@class='oxd-topbar-body-nav-tab']/a[@class='oxd-topbar-body-nav-tab-item']");
    By filterHeader = By.xpath("//div[@class='oxd-table-filter-header']");
    By addButton = By.xpath("//div[@class='orangehrm-header-container']");
    By vacanciesContainer = By.xpath("//div[@class='orangehrm-bottom-container']");
    By title = By.xpath("//h5");


    // Elements
    WebElement viewNavTabElement;
    WebElement filterHeaderElement;
    WebElement addButtonElement;
    WebElement titleElement;

    // Constructor
    public VacanciesPage(WebDriver driver) { vacanciesPageDriver = driver; }

    //Methods
    public void navigateToVacanciesPage()
    {
        //Navigate to view vacancies page
        viewNavTabElement = vacanciesPageDriver.findElement(viewNavTab);
        Helper.click(viewNavTabElement);
        filterHeaderElement = vacanciesPageDriver.findElement(filterHeader);
        Helper.click(filterHeaderElement);
        addButtonElement = vacanciesPageDriver.findElement(addButton);
        Helper.click(addButtonElement);

    }

    public String getTitle()
    {
        titleElement = vacanciesPageDriver.findElement(title);
        return titleElement.getText();
    }
}


