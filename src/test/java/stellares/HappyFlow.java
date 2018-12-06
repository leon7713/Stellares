package stellares;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.*;
import resourses.base;

import java.io.IOException;

public class HappyFlow extends base {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiseDriver();
    }

    @Test(dataProvider = "getData")
    public void test (String city, String name, String lastName, String email,
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
        cs.getNextBtn().click();
        Thread.sleep(2000);


        pis.getFirstName().sendKeys(name);
        pis.getLastName().sendKeys(lastName);
        pis.getEmail().sendKeys(email);
        pis.getPhone().sendKeys(phone);
        cs.getNextBtn().click();
        Thread.sleep(2000);


        aus.getLinkedIn().sendKeys(linkedIn);
        cs.getNextBtn().click();
        Thread.sleep(4000);

        cs.getNextBtn().click();
        Thread.sleep(2000);

        ycs.getCheckBox();
        ycs.getSubmitBtn().click();
        Thread.sleep(2000);

        fe.getRocketIcon().isDisplayed();
        System.out.println(fe.getSuccessMessage().getText());
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
        //driver.close();
        //driver=null;
    }
}
