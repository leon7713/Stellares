package stellares;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObject.*;
import resourses.base;

import java.io.File;
import java.io.IOException;

public class LeonTest extends base {
    int timeOut = 4000;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiseDriver();
    }

    @Test(dataProvider = "getData")
    public void HappyFlow (String city, String name, String lastName, String email,
                      String phone, String linkedIn) throws InterruptedException {
        driver.get(prop.getProperty("url"));
        CareerSection cs = new CareerSection(driver);
        PersInformSection pis = new PersInformSection(driver);
        AboutYouSection aus = new AboutYouSection(driver);
        YourComSection ycs = new YourComSection(driver);
        FinalElement fe = new FinalElement(driver);

        cs.getCity().sendKeys(city);
        cs.getOccupation().click();
        cs.getSoftwareEng().click();
        cs.getJobStatus().click();
        cs.getActLook().click();
        Thread.sleep(timeOut);
        cs.getNextBtn().click();

        pis.getFirstName().sendKeys(name);
        pis.getLastName().sendKeys(lastName);
        pis.getEmail().sendKeys(email);
        pis.getPhone().sendKeys(phone);
        Thread.sleep(timeOut);
        cs.getNextBtn().click();

        aus.getLinkedIn().sendKeys(linkedIn);
        Thread.sleep(timeOut);
        cs.getNextBtn().click();
        Thread.sleep(timeOut);

        cs.getNextBtn().click();
        Thread.sleep(timeOut);

        ycs.getCheckBox();
        Thread.sleep(timeOut);
        ycs.getSubmitBtn().click();
        Thread.sleep(timeOut);

        fe.getRocketIcon().isDisplayed();
        System.out.println(fe.getSuccessMessage().getText());
    }

    @Test//(dataProvider = "getData")
    public void UnhappyFlow() throws InterruptedException {
        driver.get(prop.getProperty("url"));
        CareerSection cs = new CareerSection(driver);
        PersInformSection pis = new PersInformSection(driver);

        cs.getOccupation().click();
        cs.getSoftwareEng().click();
        Thread.sleep(timeOut);
        cs.getNextBtn().click();
        pis.getActiveIcon().isDisplayed();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        try
        {
            if(result.getStatus() == ITestResult.FAILURE)
            {
                File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(src, new File("C:\\test\\screenshot.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[1][6];
        data[0][0] = "London";
        data[0][1] = "Leon";
        data[0][2] = "Smith";
        data[0][3] = "leon@mail.com";
        data[0][4] = "2323232323";
        data[0][5] = "https://www.linkedin.com/in/dannyo3/";
        return data;
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver=null;
    }
}
