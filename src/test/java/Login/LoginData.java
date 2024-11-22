package Login;

import org.testng.annotations.DataProvider;

public class LoginData {


    @DataProvider(name = "ValidTestData")
    public static Object[][] validData()
    {
        return new Object[][]{
                {"Admin","admin123"}//valid username & password
        };

    }

    @DataProvider(name = "InValidTestData")
    public static Object[][] inValidData()
    {
        return new Object[][]
                {

                        {"Admin","admi"},// incorrect password
                        {"Adm","admin123"},//incorrect username
                        {"Admin41551","admin11523"},//incorrect password & incorrect username

                };

    }

    @DataProvider(name = "emptyTestDataUsername&password")
    public static Object[][] emptyDataUsernameAndPassword()
    {
        return new Object[][]
                {
                        {"",""}//empty username & password

                };

    }

    @DataProvider(name = "emptyTestDataUsernameOrpassword")
    public static Object[][] emptyDataUsernameOrPassword()
    {
        return new Object[][]
                {
                        {"Admin",""},//empty password
                        {"","admin123"},//empty username

                };

    }
}
