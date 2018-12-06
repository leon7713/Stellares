package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersInformSection {
    public WebDriver driver;

    public PersInformSection(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("user-first-name-input");
    By lastName = By.id("user-last-name-input");
    By eMail = By.id("user-email-address-input");
    By phone = By.id("user-phone-number-input");

    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }

    public WebElement getLastName() {
        return driver.findElement(lastName);
    }

    public WebElement getEmail() {
        return driver.findElement(eMail);
    }

    public WebElement getPhone() {
        return driver.findElement(phone);
    }
}
