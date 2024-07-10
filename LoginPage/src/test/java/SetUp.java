import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SetUp {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Navigate to the URL from config
        driver.get("https://www.saucedemo.com");

        // Maximize the browser window
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        // Wait for a duration specified in config before quitting the browser
        Thread.sleep(2000);

        // Quit the WebDriver
        driver.quit();
    }
}