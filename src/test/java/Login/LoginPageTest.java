package Login;

import Pages.Login.LoginPage;
import BaseTest.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;


    @BeforeTest
    public void setUpLoginPage() {
        super.setUp();  // Initialize driver in the parent class
    }

    @Severity(SeverityLevel.CRITICAL )
    @Owner("SHAWKY")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-1")
    @Description("  Verify that login fails when either the username, password, or both fields are incorrect")
    @Test(testName ="TC01_Invalid Login", priority = 1,dataProvider = "InValidTestData", dataProviderClass = LoginData.class)
    public void inValidLoginPageTest(String user,String pass)
    {

        loginPage=new LoginPage(driver);
        loginPage.enterUserName(user);
        loginPage.enterPassword(pass);
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.isInvalidErrorMessageVisible());
    }



    @Severity(SeverityLevel.CRITICAL )
    @Owner("SHAWKY")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-1")
    @Description(" Verify that the Login Fails When Both the Username and Password Fields Are Empty")
    @Test(testName ="TC02_Invalid Login with empty username & password ",priority = 2,dataProvider = "emptyTestDataUsername&password", dataProviderClass = LoginData.class)
    public void testEmptyUsernameAndPassword(String user,String pass)
    {
        loginPage=new LoginPage(driver);
        loginPage.enterUserName(user);
        loginPage.enterPassword(pass);
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.isDuplicateRequiredMessageVisible());
    }



    @Severity(SeverityLevel.CRITICAL )
    @Owner("SHAWKY")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-1")
    @Description(" Verify that the login fails when either the username or password field is  empty")
    @Test(testName ="TC03_Invalid Login with empty username or password ",priority = 3,dataProvider = "emptyTestDataUsernameOrpassword", dataProviderClass = LoginData.class)
    public void testEmptyUsernameOrPassword(String user,String pass)
    {
        loginPage=new LoginPage(driver);
        loginPage.enterUserName(user);
        loginPage.enterPassword(pass);
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.isRequiredErrorMessageVisible());
    }



    @Severity(SeverityLevel.CRITICAL )
    @Owner("SHAWKY")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-1")
    @Description(" Verify that the user can successfully log in with valid credentials")
    @Test(testName ="TC04_valid Login  ",priority = 4,dataProvider = "ValidTestData", dataProviderClass = LoginData.class)
    public void validLoginPageTest(String user,String pass)  {

        loginPage=new LoginPage(driver);
        loginPage.enterUserName(user);
        loginPage.enterPassword(pass);
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.isDashboardTextVisible());

    }

}
