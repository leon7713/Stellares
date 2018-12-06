package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinalElement {
    public WebDriver driver;

    public FinalElement(WebDriver driver) {
        this.driver = driver;
    }

    By rocketIcon = By.xpath("//div[@class = \"illustration\"]");
    By successMessage = By.xpath("//*[text() = \"Great, application submitted!\"]");

    public WebElement getRocketIcon() {
        return driver.findElement(rocketIcon);
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(successMessage);
    }
}
