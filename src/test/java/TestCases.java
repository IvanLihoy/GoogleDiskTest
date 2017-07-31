import Pages.LoginPage;
import org.testng.annotations.Test;


public class TestCases extends ChromeConfig {

    @Test(priority = 2)
    public void doLoginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin();
    }

    @Test(priority = 1)
    public void doLoginFailure() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.failureLogin();
    }

    @Test(priority = 3)
    public void uploadFileTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin();
        loginPage.uploadTest();
    }
}
