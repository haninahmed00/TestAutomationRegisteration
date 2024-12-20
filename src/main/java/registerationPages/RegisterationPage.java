package registerationPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterationPage {

    public RegisterationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By accountInformationHeading = By.xpath("//h2[@class='title text-center' and b[text()='Enter Account Information']]");
    private By genderMaleRadioButton = By.id("id_gender1");
    private By genderFemaleRadioButton = By.id("id_gender2");
    private By inputUserPassword = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By specialOffersCheckbox = By.id("optin");
    private By inputFirstName = By.xpath("//input[@data-qa='first_name']");
    private By inputLastName = By.xpath("//input[@data-qa='last_name']");
    private By inputCompanyName = By.xpath("//input[@data-qa='company']");
    private By inputAddressLine1 = By.xpath("//input[@data-qa='address']");
    private By inputAddressLine2 = By.xpath("//input[@data-qa='address2']");
    private By countryDropdown = By.id("country");
    private By inputState = By.xpath("//input[@data-qa='state']");
    private By inputCity = By.xpath("//input[@data-qa='city']");
    private By inputZipCode = By.xpath("//input[@data-qa='zipcode']");
    private By inputMobileNumber = By.xpath("//input[@data-qa='mobile_number']");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    WebDriver driver;

    public void validateRegistrationPageLoaded() {
        String headingText = driver.findElement(accountInformationHeading).getText();
        Assert.assertTrue(driver.findElement(accountInformationHeading).isDisplayed(), "Account Information heading not displayed.");
        Assert.assertEquals(headingText, "ENTER ACCOUNT INFORMATION", "Incorrect heading text.");
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(genderMaleRadioButton).click();
        } else if (gender.equalsIgnoreCase("female")) {
            driver.findElement(genderFemaleRadioButton).click();
        }
    }
@Step("Fill regiesteration data")
    public void fillAccountInformation(String password, String day, String month, String year) {
        driver.findElement(inputUserPassword).sendKeys(password);
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
        new Select(driver.findElement(monthDropdown)).selectByVisibleText(month);
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
        driver.findElement(newsletterCheckbox).click();
        driver.findElement(specialOffersCheckbox).click();
    }

    public void fillUserDetails(String firstName, String lastName, String company, String address1,
                                 String address2, String country, String state, String city,
                                 String zipCode, String mobileNumber) {
        driver.findElement(inputFirstName).sendKeys(firstName);
        driver.findElement(inputLastName).sendKeys(lastName);
        driver.findElement(inputCompanyName).sendKeys(company);
        driver.findElement(inputAddressLine1).sendKeys(address1);
        driver.findElement(inputAddressLine2).sendKeys(address2);
        new Select(driver.findElement(countryDropdown)).selectByValue(country);
        driver.findElement(inputState).sendKeys(state);
        driver.findElement(inputCity).sendKeys(city);
        driver.findElement(inputZipCode).sendKeys(zipCode);
        driver.findElement(inputMobileNumber).sendKeys(mobileNumber);
    }
  @Step("Click create account botton")
    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }


}
