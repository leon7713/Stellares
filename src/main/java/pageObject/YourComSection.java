package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourComSection {
    public WebDriver driver;

    public YourComSection(WebDriver driver) {
        this.driver = driver;
    }

    By submitBtn = By.xpath("//*[text() = \"Submit\"]");

    public void getCheckBox() {
        int checkBoxNum = driver.findElements(By.xpath("//div[@id = \"your-commitments\"]//input")).size();
        for (int i = 1; i <= checkBoxNum; i++) {
          driver.findElement(By.id("user-commitment-" + i + "-checkbox")).click();
        }
    }

    public WebElement getSubmitBtn() {
        return driver.findElement(submitBtn);
    }
}
