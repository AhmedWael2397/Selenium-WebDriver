# Selenium Test Automation with TestNG

## Overview

This project contains automated test cases written in Java using Selenium WebDriver and TestNG. The test cases are designed to validate the functionality of the login page of the [Sauce Demo](https://www.saucedemo.com) website. 

## Project Structure

The project is organized into the following main components:

- **Base Setup Class**: Contains the common setup and teardown methods.
- **Test Classes**: Each test class extends the base setup class and contains specific test methods.

### Configuration

A `config.properties` file is used to manage configuration settings like the URL of the application, browser type, and timeout durations. A utility class (`Config.java`) is used to read these properties.

### Test Cases

#### 1. **EmptyCredentials.java**

This test class verifies the error messages displayed when trying to log in with empty credentials.

- `EmptyUsername()`: Tests the error message when the username is empty.
- `EmptyPassword()`: Tests the error message when the password is empty.

#### 2. **InvalidCredentials.java**

This test class verifies the error message displayed when trying to log in with invalid credentials.

- `InvCredentials()`: Tests the error message when both username and password are invalid.

#### 3. **ValidCredentials.java**

This test class verifies successful login with valid credentials.

- `Credentials()`: Tests the successful login with correct username and password.

### Base Setup Class

The `SetUp` class (referred to as `BaseTest` in the examples) includes common setup and teardown methods to initialize and quit the WebDriver. All test classes extend this base class to reuse the setup and teardown logic.

### Delays in Test Cases

Delays (`Thread.sleep()`) are added in the test cases only for display purposes. These delays help to visually confirm the actions performed by the tests during execution. In a real-world scenario, it's better to use explicit waits provided by Selenium for more reliable and efficient test automation.

## How to Run the Tests

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/your-repo.git
    ```

2. **Navigate to the project directory**:
    ```bash
    cd your-repo
    ```

3. **Ensure you have the necessary dependencies installed**:
    - Java
    - Maven
    - ChromeDriver (managed automatically via WebDriverManager)

4. **Run the tests using Maven**:
    ```bash
    mvn test
    ```

## Sample Code

### Base Setup Class

```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SetUp {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Config.getProperty("url"));
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(Config.getIntProperty("timeout"));
        driver.quit();
    }
}
