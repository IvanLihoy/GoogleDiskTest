package Pages;

import Untils.Tools;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by hillel on 28.07.17.
 */
public class FilesPage extends Tools {

    public FilesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        System.out.println("LoginPage elements are initialized");
    }


    @FindBy(xpath = "//*[@id=\"drive_main_page\"]/div[2]/div/div[1]/div/div/div[3]/div[1]/div/button[1]/div[2]") WebElement new_button;
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
