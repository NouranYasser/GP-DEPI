package Navbar;

import BaseTest.BaseTest;
import Pages.NavBar.Navbar;
import io.qameta.allure.Owner;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavbarTest extends BaseTest {
    Navbar navbar;
    String adminHeader = "Admin";
    String PIMHeader = "PIM";
    String leaveHeader = "Leave";
    String timeHeader = "Time";
    String recruitmentHeader = "Recruitment";
    String dashboardHeader = "Dashboard";

    @Owner("Abdelrhman")
    @Test(  testName = "TC-Navigate Admin",
            description = "This test should navigate to Admin module",
            dependsOnMethods = {"Login.LoginPageTest.validLoginPageTest"},
            priority = 1
    )
    public void navigateAdmin()
    {
        navbar = new Navbar(driver);
        navbar.navigateAdmin();
        Assert.assertEquals(navbar.getHeader(), adminHeader, "Failed to Navigate to Admin Module");
    }

    @Owner("Abdelrhman")
    @Test(  testName = "TC-Navigate PIM",
            description = "This test should navigate to PIM module",
            dependsOnMethods = {"Login.LoginPageTest.validLoginPageTest"},
            priority = 1
    )
    public void navigatePIM()
    {
        navbar = new Navbar(driver);
        navbar.navigatePIM();
        Assert.assertEquals(navbar.getHeader(), PIMHeader, "Failed to Navigate to PIM Module");
    }

    @Owner("Abdelrhman")
    @Test(  testName = "TC-Navigate Leave",
            description = "This test should navigate to Leave module",
            dependsOnMethods = {"Login.LoginPageTest.validLoginPageTest"},
            priority = 1
    )
    public void navigateLeave()
    {
        navbar = new Navbar(driver);
        navbar.navigateLeave();
        Assert.assertEquals(navbar.getHeader(), leaveHeader, "Failed to Navigate to Leave Module");
    }

    @Owner("Abdelrhman")
    @Test(  testName = "TC-Navigate Time",
            description = "This test should navigate to Time module",
            dependsOnMethods = {"Login.LoginPageTest.validLoginPageTest"},
            priority = 1
    )
    public void navigateTime()
    {
        navbar = new Navbar(driver);
        navbar.navigateTime();
        Assert.assertEquals(navbar.getHeader(), timeHeader, "Failed to Navigate to Time Module");
    }

    @Owner("Abdelrhman")
    @Test(  testName = "TC-Navigate Recruitment",
            description = "This test should navigate to Recruitment module",
            dependsOnMethods = {"Login.LoginPageTest.validLoginPageTest"},
            priority = 1
    )
    public void navigateRecruitment()
    {
        navbar = new Navbar(driver);
        navbar.navigateRecruitment();
        Assert.assertEquals(navbar.getHeader(), recruitmentHeader, "Failed to Navigate to Recruitment Module");
    }

    @Owner("Abdelrhman")
    @Test(  testName = "TC-Navigate Dashboard",
            description = "This test should navigate to Dashboard module",
            dependsOnMethods = {"Login.LoginPageTest.validLoginPageTest"},
            priority = 1
    )
    public void navigateDashboard()
    {
        navbar = new Navbar(driver);
        navbar.navigateDashboard();
        Assert.assertEquals(navbar.getHeader(), dashboardHeader, "Failed to Navigate to Dashboard Module");
    }

}
