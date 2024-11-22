package Leave;

import Pages.Leave.ApplyPage;
import BaseTest.BaseTest;
import Pages.Leave.MyLeavePage;
import Pages.NavBar.Navbar;
import TestHelpers.Helper;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.*;


public class Apply extends BaseTest {
    ApplyPage applyPage;
    MyLeavePage myLeavePage;
    Navbar navbar;


    // Messages
    String SuccessMessage = "Success\nSuccessfully Saved";
    String cancelLeaveSuccessMessage = "Success\nSuccessfully Updated";
    String WarningMessage = "Warning\nFailed to Submit";


    @DataProvider(name = "ApplyLeave")
    public Object[][] ApplyLeaveData() {
        return new Object[][] {
            {"2024-01-10", "2024-02-10", "Leave for vacation"}
        };
    }

    @Owner("Abdelrhman")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-379")
    @Test(  testName = "TC-Navigate Apply Leave",
            dependsOnMethods = {"Login.LoginPageTest.validLoginPageTest"},
            description = "This test will navigate to the apply leave page"
    )
    public void navigateApplyLeave()
    {
        applyPage = new ApplyPage(driver);
        navbar = new Navbar(driver);
        navbar.navigateLeave();
        applyPage.navigateApplyLeave();

    }

    @Owner("Abdelrhman")
    @Test(  testName = "TC-Apply Leave",
            dependsOnMethods = "navigateApplyLeave",
            dataProvider = "ApplyLeave",
            description = "This test will apply for a leave"
    )
    public void applyLeave(String fromDate, String toDate, String comment)
    {
        // date format yyyy-dd-mm
        applyPage.ApplyLeave(fromDate, toDate, comment);
        // check if the message is displayed
        Assert.assertEquals(applyPage.getMessage(),SuccessMessage);
        applyPage.closeMessage();
    }


    @Owner("Abdelrhman")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-71")
    @Test(  testName = "TC-Apply Leave Overlap",
            dependsOnMethods = "applyLeave",
            dataProvider = "ApplyLeave", description = "This test will apply for a leave that overlaps with another leave"
    )
    public void applyLeaveOverlap(String fromDate, String toDate, String comment) {
        // date format yyyy-dd-mm
        applyPage.ApplyLeave(fromDate, toDate, comment);
        // check if the message is displayed
        Assert.assertEquals(applyPage.getMessage(), WarningMessage);
        applyPage.closeMessage();
    }


    @Owner("Abdelrhman")
    @Test(  testName = "TC-Navigate My Leave",
            dependsOnMethods = {"Login.LoginPageTest.validLoginPageTest"},
            description = "This test will navigate to the my leave page"
    )
    public void navigateMyLeave() {
        myLeavePage = new MyLeavePage(driver);
        myLeavePage.navigateMyLeave();
    }


    @Owner("Abdelrhman")
    @Test(  testName = "TC-Cancel Leave",
            dependsOnMethods = {"navigateMyLeave"},
            description = "This test will cancel a leave that was applied for"
    )
    public void cancelLeave() {
        Helper.wait(driver, 5);
        myLeavePage.cancelLeave();
        // check if the message is displayed
        Assert.assertEquals(myLeavePage.getMessage(), cancelLeaveSuccessMessage);
        myLeavePage.closeMessage();
    }

    @Owner("Abdelrhman")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-72")
    @Test(  testName = "TC-Apply Leave After Cancel",
            dependsOnMethods = {"cancelLeave"},
            dataProvider = "ApplyLeave",
            description = "This test will apply for a leave that overlaps with another leave that is canceled"
    )
    public void applyLeaveOverlapAfterCancel(String fromDate, String toDate, String comment) {
        applyPage.navigateApplyLeave();
        // date format yyyy-dd-mm
        applyPage.ApplyLeave(fromDate, toDate, comment);
        // check if the message is displayed
        Assert.assertEquals(applyPage.getMessage(), SuccessMessage);
        applyPage.closeMessage();
    }
}
