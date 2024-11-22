package Pages.NavBar;

import TestHelpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navbar {
    // driver
    WebDriver navbarDriver;

    // locators
    By AdminModule = By.xpath("//a[@class='oxd-main-menu-item'][.//span[text()='Admin']]");
    By PIMModule = By.xpath("//a[@class='oxd-main-menu-item'][.//span[text()='PIM']]");
    By leaveModule = By.xpath("//a[@class='oxd-main-menu-item'][.//span[text()='Leave']]");
    By timeModule = By.xpath("//a[@class='oxd-main-menu-item'][.//span[text()='Time']]");
    By recruitmentModule = By.xpath("//a[@class='oxd-main-menu-item'][.//span[text()='Recruitment']]");
    By dashboardModule = By.xpath("//a[@class='oxd-main-menu-item'][.//span[text()='Dashboard']]");
    By header = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    // Elements
    WebElement AdminModuleElement;
    WebElement PIMModuleElement;
    WebElement leaveModuleElement;
    WebElement timeModuleElement;
    WebElement recruitmentModuleElement;
    WebElement dashboardModuleElement;
    WebElement headerElement;


    // constructor
    public Navbar(WebDriver driver) {
        navbarDriver = driver;
    }

    // methods
    public void navigateAdmin()
    {
        // navigate to the admin module
        AdminModuleElement = navbarDriver.findElement(AdminModule);
        Helper.click(AdminModuleElement);
    }

    public void navigatePIM()
    {
        // navigate to the PIM module
        PIMModuleElement = navbarDriver.findElement(PIMModule);
        Helper.click(PIMModuleElement);
    }

    public void navigateLeave()
    {
        // navigate to the leave module
        leaveModuleElement = navbarDriver.findElement(leaveModule);
        Helper.click(leaveModuleElement);
    }

    public void navigateTime()
    {
        // navigate to the time module
        timeModuleElement = navbarDriver.findElement(timeModule);
        Helper.click(timeModuleElement);
    }

    public void navigateRecruitment()
    {
        // navigate to the recruitment module
        recruitmentModuleElement = navbarDriver.findElement(recruitmentModule);
        Helper.click(recruitmentModuleElement);
    }

    public void navigateDashboard()
    {
        // navigate to the dashboard module
        dashboardModuleElement = navbarDriver.findElement(dashboardModule);
        Helper.click(dashboardModuleElement);
    }

    public String getHeader()
    {
        // get the header text
        headerElement = navbarDriver.findElement(header);
        return headerElement.getText();
    }

}
