import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class EmptyCredentials {
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

    @Test(priority = 1)
    public void EmptyUsername() throws InterruptedException {
        driver.navigate().to("https://www.saucedemo.com");
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("pass");
        Thread.sleep(2000);
        WebElement LoginButton = driver.findElement(By.id("login-button"));
        LoginButton.click();
        Thread.sleep(3000);
        //WebElement ErrorMessageField = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username is required')]"));
        //Assert.assertTrue(ErrorMessageField.isDisplayed());
        Assert.assertTrue(ErrorMessage.isDisplayed());
    }

    @Test(priority = 0)
    public void EmptyPassword() throws InterruptedException {
        WebElement UsernameField = driver.findElement(By.id("user-name"));
        WebElement PasswordField = driver.findElement(By.id("password"));
        UsernameField.sendKeys("user");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
        //WebElement ErrorMessageField = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Password is required')]"));
        //Assert.assertTrue(ErrorMessageField.isDisplayed());
        Assert.assertTrue(ErrorMessage.isDisplayed());
        Thread.sleep(2000);
        UsernameField.clear();
    }
}

