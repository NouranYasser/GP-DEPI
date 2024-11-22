package Dashboard;

import BaseTest.BaseTest;
import Pages.Dashboard.DashboardPage;
import Pages.NavBar.Navbar;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    DashboardPage dashboardPage;
    Navbar navbar;

    @BeforeTest
    public void setUpDashboard() {super.setUp();}

    @Test(dependsOnMethods = "Login.LoginPageTest.validLoginPageTest")
    public void quickLaunchApplyLeave()
    {
        dashboardPage = new DashboardPage(driver);
        navbar = new Navbar(driver);

        dashboardPage.clickApplyLeaveButton();

        Assert.assertEquals(dashboardPage.getTitle(),"Apply Leave");
    }

    @Test(dependsOnMethods = "quickLaunchApplyLeave")

    public void quickLaunchAssignLeave()
    {
        navbar.navigateDashboard();

        dashboardPage.clickAssignLeaveButton();

        Assert.assertEquals(dashboardPage.getTitle(),"Assign Leave");

    }

    @Test(dependsOnMethods = "quickLaunchAssignLeave")

    public void quickLaunchLeaveList()
    {
        navbar.navigateDashboard();

        dashboardPage.clickLeaveListButton();

        Assert.assertEquals(dashboardPage.getLeaveListTitle(),"Leave List");
    }

    @Test(dependsOnMethods = "quickLaunchLeaveList")

    public void quickLaunchMyLeave()
    {
        navbar.navigateDashboard();

        dashboardPage.clickMyLeaveButton();

        Assert.assertEquals(dashboardPage.getLeaveListTitle(),"My Leave List");
    }

    @Test(dependsOnMethods = "quickLaunchMyLeave")

    public void quickLaunchTimesheets()
    {
        navbar.navigateDashboard();

        dashboardPage.clickTimesheetsButton();

        Assert.assertEquals(dashboardPage.getTitle(),"Select Employee");
    }

    @Test(dependsOnMethods = "quickLaunchTimesheets")

    public void quickLaunchMyTimesheet()
    {
        navbar.navigateDashboard();

        dashboardPage.clickMyTimesheetButton();

        Assert.assertEquals(dashboardPage.getTitle(),"My Timesheet");
    }
}
