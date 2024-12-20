package registerationPages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AccountCreatedPage {


    WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public By accountCreatedAlert = By.xpath("//h2[@class='title text-center']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
@Step("Validate account created ")
    public void validateAccountCreated(String ValidationMesseage) {
        Assert.assertTrue(driver.findElement(accountCreatedAlert).isDisplayed(), "Account creation alert not displayed.");
        Assert.assertEquals(driver.findElement(accountCreatedAlert).getText(), ValidationMesseage, "Account creation alert not displayed.");
    }
    @Step("Click continue botton ")
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
