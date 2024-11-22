package Recruitment;

import BaseTest.BaseTest;
import Pages.Recruitment.AddVacanciesPage;
import Pages.NavBar.Navbar;
import TestHelpers.Helper;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddVacanciesTest extends BaseTest {
    AddVacanciesPage addVacanciesPage;
    Navbar navbar;
    String editVacancy = "Edit Vacancy";

    @BeforeTest
    public void setUpAddVacanciesPage()
    {
        super.setUp();
    }

    @Test(dependsOnMethods = "Login.LoginPageTest.validLoginPageTest")
    public void navigateAddVacanciesPage()
    {
        addVacanciesPage = new AddVacanciesPage(driver);
        navbar = new Navbar(driver);
        navbar.navigateRecruitment();
        addVacanciesPage.navigateAddVacanciesPage();
    }

    @Test(dependsOnMethods = "navigateAddVacanciesPage")

    public void addVacanciesPage()
    {
        addVacanciesPage.addVacanciesPage( "Senior Account Assistant","A");
        Assert.assertTrue(addVacanciesPage.getTitle().contains(editVacancy), "Successfully Saved");
    }
}
