import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.By;


public class ValidCredentials {
   WebDriver driver = new ChromeDriver();

   @BeforeClass
    public void PreConditions() {
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.saucedemo.com");
       driver.manage().window().fullscreen();
    }

    @AfterClass
    public void PostConditions() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void Credentials() throws InterruptedException {
        WebElement UserNameField=driver.findElement(By.id("user-name"));
        UserNameField.sendKeys("standard_user");
        Thread.sleep(2000);
        WebElement PasswordField=driver.findElement(By.id("password"));
        Thread.sleep(2000);
        PasswordField.sendKeys("secret_sauce");
        WebElement LoginButton=driver.findElement(By.id("login-button"));
        Thread.sleep(2000);
        LoginButton.click();
        Thread.sleep(3000);
        WebElement div=driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]"));
        Assert.assertTrue(div.isDisplayed(),"Error after Login, Missing Div");
    }
}