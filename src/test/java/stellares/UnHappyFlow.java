package stellares;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.*;
import resourses.base;

import java.io.IOException;

public class UnHappyFlow extends base {

    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiseDriver();
    }

    @Test//(dataProvider = "getData")
    public void test() throws InterruptedException {
        driver.get(prop.getProperty("url"));
        CareerSection cs = new CareerSection(driver);

        cs.getOccupation().click();
        cs.getSoftwareEng().click();
        cs.getNextBtn().click();
    }

    /*@DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[1][1];
        return data;
    }*/

    @AfterTest
    public void tearDown() {
        //driver.close();
        //driver=null;
    }
}
