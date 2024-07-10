import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPage extends SetUp {
   // Test method to check the presence of DOM elements
   @Test
   public void DomCheck(){
      // Find the Username field and verify its presence
      WebElement UserNameField = driver.findElement(By.id("user-name"));
      Assert.assertTrue(UserNameField.isDisplayed(),"Username field is not displayed");
      System.out.println("UserName field is displayed");

      // Find the Password field and verify its presence
      WebElement PasswordField = driver.findElement(By.id("password"));
      Assert.assertTrue(PasswordField.isDisplayed(),"Password field is not displayed");
      System.out.println("Password field is displayed");

      // Find the Login button and verify its presence
      WebElement LoginButton = driver.findElement(By.id("login-button"));
      Assert.assertTrue(LoginButton.isDisplayed(),"Login button is not displayed");
      System.out.println("Login button is displayed");
   }
}




