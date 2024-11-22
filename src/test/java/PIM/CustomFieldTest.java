package PIM;

import BaseTest.BaseTest;
import Pages.PIM.CustomFieldPage;
import Pages.NavBar.Navbar;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CustomFieldTest extends BaseTest {
    String SuccessMessage = "Success";
    String fieldName = "Blood";
    private Navbar navbar;
    private CustomFieldPage CustomFieldPage;


    @Owner("Nouran")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-379")
    @Test(
            testName = "TC-379",
            dependsOnMethods = "Login.LoginPageTest.validLoginPageTest",
            description = "This test will Verify that admin can navigate to custom field"
    )
    public void navigateToAddCustomField() {
        navbar = new Navbar(driver);
        CustomFieldPage = new CustomFieldPage(driver);
        navbar.navigatePIM();
        CustomFieldPage.NavigateToAddCustomField();
    }

    @Owner("Nouran")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-38")
    @Test(
            testName = "TC-38",
            dependsOnMethods = "navigateToAddCustomField",
            description = "This test will Verify that admin can add custom field"
    )
    public void addCustomField() {
        CustomFieldPage.addCustomField(fieldName);
        Assert.assertTrue(CustomFieldPage.getMessage().contains(SuccessMessage), "The message is not displayed");
        CustomFieldPage.closeMessage();
    }
    @Owner("Nouran")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-44")
    @Test(
            testName = "TC-44",
            dependsOnMethods = "addCustomField",
            description = "This test will Verify that admin can delete custom field"
    )
    public void deleteCustomField() {
        CustomFieldPage.deleteCustomField();
        Assert.assertTrue(CustomFieldPage.getMessage().contains(SuccessMessage), "The message is not displayed");
        CustomFieldPage.closeMessage();
    }
}


