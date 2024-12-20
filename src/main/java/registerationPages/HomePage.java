package registerationPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoImage = By.xpath("//img[@alt='Website for automation practice']");
    private By homeButton = By.xpath("//a[i[@class='fa fa-home']]");
   @Step("open website")
    public void navigate(){
        driver.navigate().to("https://www.automationexercise.com/");

    }

    public void asserteHomePage() {
        Assert.assertTrue(driver.findElement(logoImage).isDisplayed(), "Logo not displayed.");
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Incorrect Page Title");
        Assert.assertTrue(driver.getCurrentUrl().contains("automation"), "Incorrect URL");
        Assert.assertTrue(driver.findElement(homeButton).isDisplayed(), "Home button not displayed.");
    }
}
