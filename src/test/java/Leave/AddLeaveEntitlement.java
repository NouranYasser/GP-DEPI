package Leave;

import BaseTest.BaseTest;
import Pages.Leave.AddLeaveEntitlementPage;
import Pages.NavBar.Navbar;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddLeaveEntitlement extends BaseTest {
    AddLeaveEntitlementPage addLeaveEntitlementPage;
    Navbar navbar;
    // Messages
    String SuccessMessage = "Success";



    @Owner("Abdelrhman")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-379")
    @Test(  testName = "TC-7",
            dependsOnMethods = {"Login.LoginPageTest.validLoginPageTest"},
            description = "This test will navigate to the add leave entitlement page"
    )
    public void navigateAddLeaveEntitlement()
    {
        addLeaveEntitlementPage = new AddLeaveEntitlementPage(driver);
        navbar = new Navbar(driver);
        navbar.navigateLeave();
        addLeaveEntitlementPage.navigateAddLeaveEntitlement();
    }

    @Owner("Abdelrhman")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-239")
    @Test(  testName = "TC-8",
            dependsOnMethods = "navigateAddLeaveEntitlement",
            description = "This test will add a leave entitlement for all employees"
    )
    public void addLeaveEntitlement()
    {
        addLeaveEntitlementPage.addLeaveEntitlement("20");
        // check if the message is displayed
        Assert.assertTrue(addLeaveEntitlementPage.getMessage().contains(SuccessMessage), "The message is not displayed");
        addLeaveEntitlementPage.closeMessage();
    }


}
