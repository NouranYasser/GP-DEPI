package PIM;

import BaseTest.BaseTest;
import Pages.PIM.ReportsPage;
import Pages.NavBar.Navbar;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReportsTest extends BaseTest {
    private Navbar navbar;
    private ReportsPage reportsPage;

    @Owner("Nouran")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-379")
    @Test(
            testName = "TC-3",
            dependsOnMethods = "Login.LoginPageTest.validLoginPageTest",
            description = "This test will Verify that admin can navigate to Reports"
    )
    public void navigateToReports() {
        navbar = new Navbar(driver);
        reportsPage = new ReportsPage(driver);
        navbar.navigatePIM();
        reportsPage.NavigateToReportPage();
    }

    @Owner("Nouran")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-379")
    @Test(
            testName = "TC-5",
            dependsOnMethods = "navigateToReports",
            description = "This test will Verify that admin can search to Reports"
    )
    public void searchReports() {
        reportsPage.SearchedReportName("Employee");

    }
    @Owner("Nouran")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-379")
    @Test(
            testName = "TC-5",
            dependsOnMethods = "navigateToReports",
            description = "This test will Verify that admin can Reset the search "
    )
    public void ResetSearch() {
        reportsPage.clickOnResetButton();

    }



}



