import Pages.FilesPage;
import Pages.LoginPage;
import Report.TestRail;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TestCases extends ChromeConfig {

    private LoginPage loginPage;
    private FilesPage filesPage;
    private TestRail trReport;

    @BeforeTest
    protected void initDBPages() {
        loginPage = new LoginPage(driver);
        filesPage = new FilesPage(driver);
    }

    @BeforeClass
    protected void prepareTestRailRun() throws Exception {
        trReport = new TestRail();
        trReport.startRun(3, "GoogleDiskTest - " + new SimpleDateFormat("dd/MM/yy HH:mm").format(new Date()));
    }

    @AfterMethod
    protected void reportResult(ITestResult testResult) throws Exception {
        String testDescription = testResult.getMethod().getDescription();
        trReport.setResult(Integer.parseInt(testDescription.substring(0, testDescription.indexOf("."))), testResult.getStatus());
    }

    @AfterMethod
    protected void addCaseIfAbsent(ITestResult testResult) {

    }

    @AfterClass
    protected void closeTestRailRun() throws Exception {
        trReport.endRun();
    }

    @Test(description = "116. Failure Login", priority = 1)
    public void doLoginFailure() {
        loginPage.failureLogin();
    }

    @Test(description = "117. Success Login", priority = 2)
    public void doLoginSuccess() {
        loginPage.successLogin();
    }

    @Test(description = "118. Upload File", priority = 3, dependsOnMethods = "doLoginSuccess")
    public void uploadFileTest(){
        filesPage.uploadTest();
    }

    @Test(description = "119. Delete File", priority = 4, dependsOnMethods = "uploadFileTest")
    public void removeFileTest(){
        filesPage.removeTest();
    }
}
