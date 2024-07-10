import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class InvalidCredentials extends SetUp {

    // Test method to verify error message for invalid credentials
    @Test
    public void InvCredentials() throws InterruptedException {
        // Find the username field and enter a username
        WebElement UserNameField = driver.findElement(By.id("user-name"));
        UserNameField.sendKeys("user");

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Find the password field and enter a password
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("pass");

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Find the login button
        WebElement LoginButton = driver.findElement(By.id("login-button"));

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Click the login button
        LoginButton.click();

        // Wait for 3 seconds
        Thread.sleep(3000);

        // Find the error message element for invalid credentials
        WebElement ErrorMessageField = driver.findElement(By.xpath("//div[@class='error-message-container error']"));

        // Verify the error message is displayed
        Assert.assertTrue(ErrorMessageField.isDisplayed());

        /*
        another way using different locator
        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]"));
        Assert.assertTrue(ErrorMessage.isDisplayed());
         */



    }
}
