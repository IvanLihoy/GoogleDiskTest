import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by hillel on 28.07.17.
 */
public class ChromeConfig {
    protected WebDriver driver;
    @BeforeTest
    protected void startChrome(){
        System.setProperty("webdriver.chrome.driver","/home/hillel/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
