import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;



public class InvalidCredentials {
    WebDriver driver = new ChromeDriver();
    @BeforeClass
    public void PreConditions() {
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public void PostConditions() throws InterruptedException {
        Thread.sleep(7000);
        driver.quit();
    }
    @Test
    public void InvCredentials() throws InterruptedException {
        WebElement UserNameField = driver.findElement(By.id("user-name"));
        UserNameField.sendKeys("user");
        Thread.sleep(2000);
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("pass");
        Thread.sleep(2000);
        WebElement LoginButton = driver.findElement(By.id("login-button"));
        Thread.sleep(2000);
        LoginButton.click();
        Thread.sleep(3000);
        WebElement ErrorMessageField = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
        //WebElement ErrorMessage = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]"));
        Assert.assertTrue(ErrorMessageField.isDisplayed());
        //Assert.assertTrue(ErrorMessage.isDisplayed());
    }
}