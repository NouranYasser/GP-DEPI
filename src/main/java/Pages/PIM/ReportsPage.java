package Pages.PIM;
import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class ReportsPage {
    WebDriver ReportsDriver;

    By Reports = By.xpath("//a[contains(text(), 'Reports')]");
    By SearchButton = By.xpath("//button[@type='submit']");
    By ReportName = By.xpath("//input[@placeholder='Type for hints...']");
    By ResetButton = By.xpath("//div[@class='oxd-form-actions']/button[@type='button']");

    WebElement SearchButtonElement;
    WebElement ResetButtonElement;

    WebElement ReportButtonElement;
    WebElement ReportNameElement;

    public ReportsPage(WebDriver driver) {
        this.ReportsDriver = driver;
    }

    public void NavigateToReportPage() {
        ReportButtonElement = ReportsDriver.findElement(Reports);
        Helper.click(ReportButtonElement);
    }

    public void EnterReportName(String ReportName) {
        ReportNameElement = ReportsDriver.findElement(this.ReportName);
        Helper.sendKeys(ReportNameElement , ReportName);
    }

    public void ClickSearchReports(){
        SearchButtonElement = ReportsDriver.findElement(SearchButton);
        Helper.click(SearchButtonElement);
    }
    public void SearchedReportName(String ReportName) {
        EnterReportName(ReportName);
        ClickSearchReports();
    }

    public void clickOnResetButton() {
        ResetButtonElement = ReportsDriver.findElement(ResetButton);
        Helper.click(ResetButtonElement);
    }


}
