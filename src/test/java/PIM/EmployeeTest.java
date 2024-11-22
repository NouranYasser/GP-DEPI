package PIM;
import BaseTest.BaseTest;
import Pages.PIM.EmployeePage;
import Pages.NavBar.Navbar;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
public class EmployeeTest extends BaseTest{
    String FirstName ="Nouran";
    String MiddleName ="Yasser";
    String LastName ="Mostafa";
    String Username ="NouraYasser";
    String Password ="Nouran2003";

    String ExpectedMessage = "Add Employee";
    private String ConfirmPassword ="Nouran2003";
    private Navbar navbar;
    private EmployeePage employeePage;

    @Owner("Nouran")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-379")
    @Test(
            testName = "TC-1E",
            dependsOnMethods = "Login.LoginPageTest.validLoginPageTest",
            description = "This test will Verify that admin can add New Employee"
    )
    public void NavigateToAddEmployee() {
        navbar = new Navbar(driver);
        employeePage = new EmployeePage(driver);
        navbar.navigatePIM();
        employeePage.NavigateToAddEmployee();
        Assert.assertEquals(employeePage.getPageTitle(), "Add Employee");
    }

    @Owner("Nouran")
    @Issue("https://ahmed22968337.atlassian.net/browse/DEPI235-379")
    @Test(
            testName = "TC-2E",
            dependsOnMethods = "NavigateToAddEmployee",
            description = "This test will Verify that admin can add New Employee"
    )
    public void AddEmployee() {
        employeePage.AddEmployee(FirstName,MiddleName,LastName,Username,Password,ConfirmPassword);
        Assert.assertEquals(employeePage.getPageTitle(), ExpectedMessage);
    }

}
