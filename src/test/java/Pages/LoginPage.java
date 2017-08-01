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
        sleep(5);
    }

    public void successLogin(){
        loginToGoogle("Password11");
        Assert.assertTrue(driver.getTitle().contains("My Drive - Google Drive"));
    }

    public void failureLogin(){
        loginToGoogle("Password22");
        Assert.assertTrue(second_next_button.isDisplayed());
    }

    @FindBy (xpath = "//*[@id=\"drive_main_page\"]/div[2]/div/div[1]/div/div/div[3]/div[1]/div/button[1]/div[2]") WebElement new_button;
    @FindBy (xpath = "//*[contains(text(), 'File upload')]") WebElement upload_file_button;
    @FindBy (xpath = "html/body/input[2]") WebElement file_input;

    private final String FILEPATH = "C:\\Users\\Ivan\\IvanLihoy.txt";

    private void uploadFile() {
        new_button.click();
        sleep(5);
        upload_file_button.click();
        file_input.sendKeys(FILEPATH);
        sleep(5);
    }

    @FindBy (xpath = "//*[contains(text(), 'IvanLihoy.txt')]") WebElement uploaded_file;
    @FindBy (css = "div[aria-label='Remove']") WebElement remove_button;

    private void removeFile(){
        uploaded_file.click();
        sleep(2);
        remove_button.click();
        sleep(2);
    }

    public void removeTest(){
        removeFile();
        Assert.assertTrue(uploaded_file.isEnabled());
    }

    public void uploadTest(){
        uploadFile();
    }
}
