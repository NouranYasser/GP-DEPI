package Pages.Dashboard;

import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage {

    //Driver
    WebDriver dashboardDriver;

    //Locators
    By Title = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
    By leaveListTitle = By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']");
    By quickLaunchApplyLeave = By.xpath("//button[@title='Apply Leave']");
    By quickLaunchAssignLeave = By.xpath("//button[@title='Assign Leave']");
    By quickLaunchLeaveList = By.xpath("//button[@title='Leave List']");
    By quickLaunchMyLeave = By.xpath("//button[@title='My Leave']");
    By quickLaunchTimesheets = By.xpath("//button[@title='Timesheets']");
    By quickLaunchMyTimesheet = By.xpath("//button[@title='My Timesheet']");


    //Elements
    WebElement TitleElement;
    WebElement LeaveListTitleElement;
    WebElement quickLaunchApplyLeaveElement;
    WebElement quickLaunchAssignLeaveElement;
    WebElement quickLaunchLeaveListElement;
    WebElement quickLaunchMyLeaveElement;
    WebElement quickLaunchTimesheetsElement;
    WebElement quickLaunchMyTimesheetElement;

    //Constructor
    public DashboardPage(WebDriver driver) { dashboardDriver = driver; }

    //Methods

    public void     clickApplyLeaveButton() {
        quickLaunchApplyLeaveElement = dashboardDriver.findElement(quickLaunchApplyLeave);
        Helper.click(quickLaunchApplyLeaveElement);
    }

    public void     clickAssignLeaveButton() {
        quickLaunchAssignLeaveElement = dashboardDriver.findElement(quickLaunchAssignLeave);
        Helper.click(quickLaunchAssignLeaveElement);
    }

    public void     clickLeaveListButton() {
        quickLaunchLeaveListElement = dashboardDriver.findElement(quickLaunchLeaveList);
        Helper.click(quickLaunchLeaveListElement);
    }

    public void     clickMyLeaveButton() {
        quickLaunchMyLeaveElement = dashboardDriver.findElement(quickLaunchMyLeave);
        Helper.click(quickLaunchMyLeaveElement);
    }

    public void     clickTimesheetsButton() {
        quickLaunchTimesheetsElement = dashboardDriver.findElement(quickLaunchTimesheets);
        Helper.click(quickLaunchTimesheetsElement);
    }

    public void     clickMyTimesheetButton() {
        quickLaunchMyTimesheetElement = dashboardDriver.findElement(quickLaunchMyTimesheet);
        Helper.click(quickLaunchMyTimesheetElement);
    }

    public String getTitle() {
        TitleElement = dashboardDriver.findElement(Title);
        return TitleElement.getText();
    }

    public String getLeaveListTitle() {
        LeaveListTitleElement = dashboardDriver.findElement(leaveListTitle);
        return LeaveListTitleElement.getText();
    }

}
