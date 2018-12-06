package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareerSection {
    public WebDriver driver;

    public CareerSection (WebDriver driver) {
        this.driver = driver;
    }

    By city = By.id("geocomplete");
    By occupation = By.xpath("//*[text() =  \"Select your Occupation\"]");
    By softwareEngeneer = By.xpath("//*[text() = \"Software Engineer\"]");
    By jobStatus = By.xpath("//*[text() = \"Select your Job Status\"]");
    By activelyLooking = By.xpath("//*[text() = \"Actively looking\"]");
    By nextBtn = By.xpath("//button[@class = \"actions__next\"]");

    public WebElement getCity() {
        return driver.findElement(city);
    }

    public WebElement getOccupation() {
        return driver.findElement(occupation);
    }

    public WebElement getSoftwareEng() {
        return driver.findElement(softwareEngeneer);
    }

    public WebElement getJobStatus() {
        return driver.findElement(jobStatus);
    }

    public WebElement getActLook() {
        return driver.findElement(activelyLooking);
    }

    public WebElement getNextBtn() {
        return driver.findElement(nextBtn);
    }
}
