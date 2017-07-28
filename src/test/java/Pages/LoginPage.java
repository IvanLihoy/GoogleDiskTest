package Pages;

import Untils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by hillel on 28.07.17.
 */
public class LoginPage extends Tools{
    protected WebDriver driver;
    @BeforeTest
    protected void startChrome(){
        System.setProperty("webdriver.chrome.driver","/home/hillel/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/drive/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    void loginToGoogle() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[data-g-action='Intro']")).click();
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("testusermail2017@gmail.com");
        driver.findElement(By.cssSelector("div#identifierNext")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Password11");
        driver.findElement(By.cssSelector("div#passwordNext")).click();
        Thread.sleep(4000);
    }

    void uploadFile() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"drive_main_page\"]/div[2]/div/div[1]/div/div/div[3]/div[1]/div/button[1]/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div[id=':5r' class='h-v h-v-pc']")).click();
        driver.findElement(By.cssSelector(""));

    }

    @Test
    void doLogin() throws InterruptedException {
        loginToGoogle();
        uploadFile();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
