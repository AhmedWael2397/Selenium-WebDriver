import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class EmptyCredentials extends SetUp {

    // Test method to verify error message when username is empty
    @Test(priority = 1)
    public void EmptyUsername() throws InterruptedException {
        // Refresh the page
        driver.navigate().refresh();

        // Maximize the browser window
        driver.manage().window().fullscreen();

        // Find the password field and enter a password
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("pass");

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Find and click the login button
        WebElement LoginButton = driver.findElement(By.id("login-button"));
        LoginButton.click();

        // Wait for 3 seconds
        Thread.sleep(3000);

        // Find the error message element when username is empty
        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username is required')]"));

        // Verify the error message is displayed
        Assert.assertTrue(ErrorMessage.isDisplayed());
    }

    // Test method to verify error message when password is empty
    @Test(priority = 0)
    public void EmptyPassword() throws InterruptedException {
        // Find the username and password fields
        WebElement UsernameField = driver.findElement(By.id("user-name"));
        WebElement PasswordField = driver.findElement(By.id("password"));

        // Enter a username
        UsernameField.sendKeys("user");

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Find and click the login button
        driver.findElement(By.id("login-button")).click();

        // Wait for 3 seconds
        Thread.sleep(3000);

        // Find the error message element when password is empty
        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Password is required')]"));

        // Verify the error message is displayed
        Assert.assertTrue(ErrorMessage.isDisplayed());

        // Wait for 2 seconds
        Thread.sleep(2000);
    }
}
