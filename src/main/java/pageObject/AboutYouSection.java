package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutYouSection {
    public WebDriver driver;

    public AboutYouSection(WebDriver driver) {
        this.driver = driver;
    }

    By liknkedIn = By.id("user-linkedin-about");

    public WebElement getLinkedIn() {
        return driver.findElement(liknkedIn);
    }
}
