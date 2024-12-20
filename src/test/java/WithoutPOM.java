import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WithoutPOM {
        WebDriver driver = null;
        @BeforeClass
        public void openbrowser(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://automationexercise.com/");
        }
        @Test
        public void homePageloaded(){
            String homelink = driver.getCurrentUrl();
            Assert.assertEquals(homelink,"https://automationexercise.com/", "Verify that home page loaded successfully");
        }

        @Test
        public void clickonSignup() {
            WebElement signup = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
            signup.click();
        }

        @Test
        public void inputData(){
            driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Hanon");
            driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("Hano88@gmail.com");
            driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        }

        @Test
        public void fillForm(){
            driver.findElement(By.id("id_gender1")).click();
            driver.findElement(By.id("password")).sendKeys("Hano998@gmail.com");
            Select dayslist = new Select(driver.findElement(By.id("days")));
            dayslist.selectByVisibleText("2");
            Select monthlist = new Select(driver.findElement(By.id("months")));
            monthlist.selectByVisibleText("January");
            Select yearlist = new Select(driver.findElement(By.id("years")));
            yearlist.selectByVisibleText("2021");
            driver.findElement(By.id("newsletter")).click();
            driver.findElement(By.id("optin")).click();
            driver.findElement(By.id("first_name")).sendKeys("Hanoo");
            driver.findElement(By.id("last_name")).sendKeys("Mohamed");
            driver.findElement(By.id("company")).sendKeys("Giza");
            driver.findElement(By.id("address1")).sendKeys("address1");
            driver.findElement(By.id("address2")).sendKeys("address2");
            Select countrylist = new Select(driver.findElement(By.id("country")));
            countrylist.selectByVisibleText("Canada");
            driver.findElement(By.id("state")).sendKeys("state");
            driver.findElement(By.id("city")).sendKeys("city");
            driver.findElement(By.id("zipcode")).sendKeys("23245");
            driver.findElement(By.id("mobile_number")).sendKeys("012267883554");
            driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")).click();
            WebElement finaltext= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
            String finaltextt= finaltext.getText();
            Assert.assertEquals(finaltextt,"ACCOUNT CREATED!");

        }
        @AfterClass
        public void closeBrowser(){
            driver.quit();
        }
}
