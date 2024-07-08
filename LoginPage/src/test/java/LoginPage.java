import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
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
   public void DomCheck(){
      WebElement UserNameField = driver.findElement(By.id("user-name"));
      Assert.assertTrue(UserNameField.isDisplayed(),"Username field is not displayed");
      System.out.println("UserName field is displayed");
      WebElement PasswordField = driver.findElement(By.id("password"));
      Assert.assertTrue(PasswordField.isDisplayed(),"Password field is not displayed");
      System.out.println("Password field is displayed");
      WebElement LoginButton = driver.findElement(By.id("login-button"));
      Assert.assertTrue(LoginButton.isDisplayed(),"Login button is not displayed");
      System.out.println("Login button is displayed");
   }
}




