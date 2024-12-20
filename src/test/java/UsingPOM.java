
import framework.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import registerationPages.*;


public class UsingPOM {
    private WebDriver driver;
    private HomePage homepage;
    private SignUpPage signupPage;
    private RegisterationPage registerationPage;
    private AccountCreatedPage accountCreatedPage;
    private AccountDeletedPage accountDeletedPage;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.initiateDriver("chrome");
        homepage = new HomePage(driver);
        signupPage = new SignUpPage(driver);
        registerationPage = new RegisterationPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);

    }
    ///Tests
    @Test(description = "Open Home Page")
    public void test1() {
        homepage.asserteHomePage();
        homepage.navigate();
    }

    @Test(description = "Sign up with valid data")
    public void test2() {
        signupPage.navigateToSignUpPage();
        signupPage.validateNewUserHeader();
        signupPage.performSignUp("Alyo" , "aaly@test.com");


    }
    @Test (description = "Validate registeration with valid data")
    public void test3(){
        registerationPage.validateRegistrationPageLoaded();
        registerationPage.validateRegistrationPageLoaded();
        registerationPage.fillAccountInformation("2134", "29", "May", "2000");
        registerationPage.fillUserDetails("Haneen", "Ahmed", "Giza", "NewCiaro", "Zayed", "Canada", "mySatte", "Egypt", "12345", "01123575432");
        registerationPage.clickCreateAccountButton();
    }
    @Test (description = "validate account creatation ")
public void test4() {
        accountCreatedPage.validateAccountCreated("ACCOUNT CREATED!");
        accountCreatedPage.clickContinueButton();
    }
    @Test (description = "Validate account delete")
    public void test5(){
        accountDeletedPage.deleteAccount();
        accountDeletedPage.validateAccountDeleted("ACCOUNT DELETED!");

    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}