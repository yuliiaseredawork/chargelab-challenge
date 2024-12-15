package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseUiTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final String BASE_URL = "https://webapp.v1.dev.chargelab.io/Take-Home-Challenge-1";
    protected static final String LOGIN_BUTTON_XPATH = "//button[contains(text(),'Log in')]";
    protected static final String USERNAME_FIELD_SELECTOR = "input[placeholder='Email address or mobile phone number']";
    protected static final String NEXT_BUTTON_XPATH = "//button[contains(text(),'Next')]";
    protected static final String OTP_FIELD_SELECTOR = "input[placeholder='Enter code']";
    protected static final String ACCOUNT_BUTTON_SELECTOR = "button[aria-label='Go to my account']";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void login(String username, String otp) {
        driver.get(BASE_URL);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGIN_BUTTON_XPATH)));
        loginButton.click();

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(USERNAME_FIELD_SELECTOR)));
        usernameField.sendKeys(username);

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NEXT_BUTTON_XPATH)));
        nextButton.click();

        WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OTP_FIELD_SELECTOR)));
        otpField.sendKeys(otp);

        WebElement accountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ACCOUNT_BUTTON_SELECTOR)));
        Assert.assertTrue(accountButton.isDisplayed(), "Account button should be visible on the dashboard");
    }
}
