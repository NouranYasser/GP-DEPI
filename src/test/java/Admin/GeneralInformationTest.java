package Admin;

import BaseTest.BaseTest;
import Pages.Admin.GeneralInformationPage;
import Pages.NavBar.Navbar;
import org.testng.Assert;
import org.testng.annotations.*;

public class GeneralInformationTest extends BaseTest
{
    GeneralInformationPage generalInformationPage;
    String SuccessMessage = "Success\nSuccessfully Updated";
    Navbar navbar;


    @DataProvider (name = "EditOrganizationDetails")
    public Object[][] EditOrganizationDetailsData() {
        return new Object[][]{
                {"DEPI Project", "YAT", "235", "012345679", "0022", "example@gmail.com", "Cairo Egypt", "Giza Egypt", "October", "Cairo", "01234", "Final Project"}
        };
    }

    @Test (dependsOnMethods = {"Login.LoginPageTest.validLoginPageTest"} ,description = "This test will navigate to the general information page")
    public void NavigateAdmin ()
    {
        navbar = new Navbar(driver);
        navbar.navigateAdmin();
        generalInformationPage = new GeneralInformationPage(driver);
        generalInformationPage.NavigateToGeneralInformationPage();
    }


    @Test(dataProvider = "EditOrganizationDetails", dependsOnMethods = {"NavigateAdmin"}, description = "This test will edit the organization details")
    public void EditOrganizationDetails(String organizationName, String taxID, String registrationNumber, String phone, String fax, String email, String address1, String address2, String city, String state, String zip, String notes)
    {
        generalInformationPage.EditOrganization(organizationName, taxID, registrationNumber, phone, fax, email, address1, address2, city, state, zip, notes);
        Assert.assertEquals(generalInformationPage.getMessage(), SuccessMessage);
        generalInformationPage.closeMessage();
    }
}
