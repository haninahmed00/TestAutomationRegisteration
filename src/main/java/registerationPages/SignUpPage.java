package registerationPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;


public class SignUpPage {
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginButton = By.xpath("//a[@href='/login']");
    private By newUserHeading = By.xpath("(//h2)[3]");
    private By inputUserName = By.xpath("//input[@name='name']");
    private By inputUserEmail = By.xpath("//input[@data-qa='signup-email']");
    private By signUpButton = By.xpath("//button[@data-qa='signup-button']");

    WebDriver driver;
@Step("navigate to signup page")
    public void navigateToSignUpPage() {
        driver.findElement(loginButton).click();
    }

    public void validateNewUserHeader() {
        Assert.assertTrue(driver.findElement(newUserHeading).isDisplayed(), "New User heading not displayed.");
    }
@Step("Perform signup")
    public void performSignUp(String username, String email) {
        driver.findElement(inputUserName).sendKeys(username);
        driver.findElement(inputUserEmail).sendKeys(email);
        driver.findElement(signUpButton).click();
    }
}

