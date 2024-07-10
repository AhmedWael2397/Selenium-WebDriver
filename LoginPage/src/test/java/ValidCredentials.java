import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.By;

public class ValidCredentials extends SetUp {

    // Test method to verify login with valid credentials
    @Test
    public void Credentials() throws InterruptedException {
        // Find the username field and enter a valid username
        WebElement UserNameField = driver.findElement(By.id("user-name"));
        UserNameField.sendKeys("standard_user");

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Find the password field
        WebElement PasswordField = driver.findElement(By.id("password"));

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Enter a valid password
        PasswordField.sendKeys("secret_sauce");

        // Find the login button
        WebElement LoginButton = driver.findElement(By.id("login-button"));

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Click the login button
        LoginButton.click();

        // Wait for 3 seconds to allow the login process to complete
        Thread.sleep(3000);

        // Find the div element that contains 'Swag Labs' text to verify successful login
        WebElement div = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]"));

        // Assert that the div element is displayed, indicating successful login
        Assert.assertTrue(div.isDisplayed(), "Error after Login, Missing Div");
    }
}
