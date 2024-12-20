
import framework.JsonFileManager;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import framework.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import registerationPages.*;

public class UsingJsonFile {
    private WebDriver driver;
    private HomePage homepage;
    private SignUpPage signupPage;
    private RegisterationPage registerationPage;
    private AccountCreatedPage accountCreatedPage;
    private AccountDeletedPage accountDeletedPage;
    private JsonFileManager jsonFileManager;
    private JsonFileManager testData;

    @BeforeClass
    public void setup() {
    jsonFileManager = new JsonFileManager("D:\\Users\\RegisterationUserTestCase\\src\\test\\resources\\TestData.json");
        driver = DriverFactory.initiateDriver("chrome");
        homepage = new HomePage(driver);
        signupPage = new SignUpPage(driver);
        registerationPage = new RegisterationPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);

    }

    @Test
    public void test1() {
        homepage.navigate();
        signupPage.navigateToSignUpPage();
        signupPage.validateNewUserHeader();
        signupPage.performSignUp(jsonFileManager.getTestData("signupPage.Name"), jsonFileManager.getTestData("signupPage.Email"));
        registerationPage.validateRegistrationPageLoaded();
        registerationPage.validateRegistrationPageLoaded();
        registerationPage.fillAccountInformation(
                jsonFileManager.getTestData("accountData.form.password"),
                jsonFileManager.getTestData("accountData.form.Day"),
                jsonFileManager.getTestData("accountData.form.Month"),
                jsonFileManager.getTestData("accountData.form.Year"));
        registerationPage.fillUserDetails(
                jsonFileManager.getTestData("accountData.form.FirstName"),
                jsonFileManager.getTestData("accountData.form.LastName"),
                jsonFileManager.getTestData("accountData.form.Company"),
                jsonFileManager.getTestData("accountData.form.Address1"),
                jsonFileManager.getTestData("accountData.form.Address2"),
                jsonFileManager.getTestData("accountData.form.Country"),
                jsonFileManager.getTestData("accountData.form.State"),
                jsonFileManager.getTestData("accountData.form.City"),
                jsonFileManager.getTestData("accountData.form.Zipcode"),
                jsonFileManager.getTestData("accountData.form.MobileNumber")
        );
        registerationPage.clickCreateAccountButton();
        accountCreatedPage.validateAccountCreated("ACCOUNT CREATED!");
        accountCreatedPage.clickContinueButton();

        By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
            driver.findElement(deleteAccountButton).click();

    }
    @AfterTest
    public void close() {
        driver.quit();

    }
}
