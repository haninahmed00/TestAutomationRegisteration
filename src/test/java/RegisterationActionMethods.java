import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class RegisterationActionMethods {
    private WebDriver driver ;
    ////home page
    String homePageURL= "https://automationexercise.com/";
    private final By signupButton = By.xpath("//i[@class=\"fa fa-lock\"]");
    ///signup page
    private final By signupPageTitle = By.xpath("//h2[contains(text(),\"New User\")]");
    private final By nameField = By.xpath("//input[@name=\"name\"]");
    private final By emailField = By.xpath("//input[@data-qa= \"signup-email\"]");
    private final By submitSignUpButton = By.xpath("//button[@data-qa= \"signup-button\"]");
    ///account info page
    private final By accountInfopageTitle = By.xpath("//b[contains(text(),\"Enter Account\")]");
    private final By accountGender = By.id("id_gender1");
    private final By accountPassword= By.id("password");
    private final By daysDate=By.id("days");
    private final By monthsDate=By.id("months");
    private final By yearsDate= By.id("years");
    private final By newsLetter=By.id("newsletter");
    private final By option=By.id("optin");
    private final By firstName=By.id("first_name");
    private final By lastName=By.id("last_name");
    private final By companyName=By.id("company");
    private final By address1Name=By.id("address1");
    private final By address2Name=By.id("address2");
    private final By countryList=By.id("country");
    private final By stateName=By.id("state");
    private final By cityName=By.id("city");
    private final By zipcodeName=By.id("zipcode");
    private final By mobileNumber=By.id("mobile_number");
    private final By submitButton= By.xpath("//button[contains(text(),\"Create Account\")]");
    ////////////Final page
    private final By accountPageTitle= By.xpath("//b[contains(text(),\"Account Created\")]");
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private By accountDeletedAlert = By.xpath("//h2[@data-qa='account-deleted']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
    ///Tests
    @Test
    public void test1(){
        Signup();
        assertSignUppage("New User Signup!");
        fillSignupData("Alyaa", "alyia@gmail.com");
        assertEnterAccountInfoPage("ENTER ACCOUNT INFORMATION");
        fillAccountData("Aly@gmail.com","2","January","2020","Alyaaa",
                "AAAA","Giza","address1","address2","Canada","state",
                "city","12345","02273665448");
        assertAccountCreated("ACCOUNT CREATED!");
        clickContinueButton();
        deleteAccount();
        assertAccountDeleted("ACCOUNT DELETED!");
    }
    @BeforeMethod
    public void ChromeNavigateToHomePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navigateToPage(homePageURL);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    //////////////////Actions ///////////////////
    public void navigateToPage(String PageURL){
        driver.navigate().to(PageURL);
    }
    public void Signup(){
        driver.findElement(signupButton).click();
    }
    public void fillSignupData(String Name, String Email){
        driver.findElement(nameField).sendKeys(Name);
        driver.findElement(emailField).sendKeys(Email);
        driver.findElement(submitSignUpButton).click();
    }
    public void fillAccountData(String password, String Day, String month, String year, String firstname,
                                    String lastname, String company, String address1, String address2,
                                    String country, String state, String city, String zipcode, String mobilenumber){
        driver.findElement(accountGender).click();
        driver.findElement(accountPassword).sendKeys(password);
        Select daysList =new Select(driver.findElement(daysDate));
        daysList.selectByVisibleText(Day);
        Select monthList =new Select(driver.findElement(monthsDate));
        monthList.selectByVisibleText(month);
        Select yearList =new Select(driver.findElement(yearsDate));
        yearList.selectByVisibleText(year);
        driver.findElement(newsLetter).click();
        driver.findElement(option).click();
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(companyName).sendKeys(company);
        driver.findElement(address1Name).sendKeys(address1);
        driver.findElement(address2Name).sendKeys(address2);
        Select countrylist= new Select(driver.findElement(countryList));
        countrylist.selectByVisibleText(country);
        driver.findElement(stateName).sendKeys(state);
        driver.findElement(cityName).sendKeys(city);
        driver.findElement(zipcodeName).sendKeys(zipcode);
        driver.findElement(mobileNumber).sendKeys(mobilenumber);
        driver.findElement(submitButton).click();
    }
    private void deleteAccount() {
        driver.findElement(deleteAccountButton).click();
    }
    private void clickContinueButton() {
        driver.findElement(continueButton).click();
    }




    // All Of Asseration methods For this test case

    public void assertSignUppage(String expecteResult){
        String actualSignUpPageTitle = driver.findElement(signupPageTitle).getText();
        Assert.assertEquals(actualSignUpPageTitle,expecteResult);
    }
    public void assertEnterAccountInfoPage(String expectedResult){
        String actualAccountInfoTitle = driver.findElement(accountInfopageTitle).getText();
        Assert.assertEquals(actualAccountInfoTitle, expectedResult);
    }
    public void assertAccountCreated(String expectedResult){
        String actualAccountCreated = driver.findElement(accountPageTitle).getText();
        Assert.assertEquals(actualAccountCreated, expectedResult);
    }
    private void assertAccountDeleted(String ValidationMesseage) {
        Assert.assertTrue(driver.findElement(accountDeletedAlert).isDisplayed(), "Account deletion alert not displayed.");
        Assert.assertEquals(driver.findElement(accountDeletedAlert).getText(),ValidationMesseage, "Account deletion alert not displayed.");

    }

}
