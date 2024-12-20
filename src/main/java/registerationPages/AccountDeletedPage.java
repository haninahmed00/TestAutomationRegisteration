package registerationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AccountDeletedPage {
    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }


    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private By accountDeletedAlert = By.xpath("//h2[@data-qa='account-deleted']");
    WebDriver driver;


    public void deleteAccount() {

        driver.findElement(deleteAccountButton).click();
    }

    public void validateAccountDeleted(String ValidationMesseage) {
        Assert.assertTrue(driver.findElement(accountDeletedAlert).isDisplayed(), "Account deletion alert not displayed.");
        Assert.assertEquals(driver.findElement(accountDeletedAlert).getText(), ValidationMesseage, "Account deletion alert not displayed.");

    }

}