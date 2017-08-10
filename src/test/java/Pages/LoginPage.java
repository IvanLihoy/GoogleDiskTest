package Pages;

import Untils.Tools;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Tools {

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        System.out.println("LoginPage elements are initialized");
    }

    @FindBy (css = "a[data-g-action='Intro']") WebElement GoToGoogleDriveButton;
    @FindBy (css = "input[type='email']") WebElement email_field;
    @FindBy (css = "div#identifierNext") WebElement first_next_button;
    @FindBy (css = "input[type='password']") WebElement pass_field;
    @FindBy (css = "div#passwordNext") WebElement second_next_button;

    private final String email_input = "testusermail2017@gmail.com";
    private final String SERVICE_URL = "https://www.google.com/drive/";

    private void loginToGoogle(String pass) {
        driver.navigate().to(SERVICE_URL);
        GoToGoogleDriveButton.click();
        email_field.sendKeys(email_input);
        first_next_button.click();
        sleep(2);
        pass_field.sendKeys(pass);
        second_next_button.click();
        sleep(8);
    }

    public void successLogin(){
        loginToGoogle("Password11");
        Assert.assertTrue(driver.getTitle().contains("My Drive - Google Drive"));
    }

    public void failureLogin(){
        loginToGoogle("Password22");
        Assert.assertTrue(second_next_button.isDisplayed());
    }


}
