package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseUiTest {

    private static final String COMPANY_LOGO_SELECTOR = "img[alt='Company Logo']";
    private static final String CHARGER_IMAGE_SELECTOR = "img[alt='Image of Take-Home-Challenge-1 charger']";
    private static final String LOCATION_TEXT_XPATH = "//p[contains(text(), '123 Fun Street')]";
    private static final String PRICING_TEXT_XPATH = "//span[contains(text(), 'Pricing')]";
    private static final String PORT1_TEXT_XPATH = "//span[contains(text(), 'Port 1 (Left)')]";
    private static final String PORT2_TEXT_XPATH = "//span[contains(text(), 'Port 2 (Right)')]";

    @Test
    public void testLoginAndDashboardElements() {
        String username = "test-user-01@chargelab.co";
        String otp = "00000";
        login(username, otp);

        // Validate presence of key elements on the dashboard
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(COMPANY_LOGO_SELECTOR)));
        Assert.assertTrue(logo.isDisplayed(), "Company logo should be visible on the dashboard");

        WebElement chargerImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CHARGER_IMAGE_SELECTOR)));
        Assert.assertTrue(chargerImage.isDisplayed(), "Charger image should be visible");

        WebElement locationText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOCATION_TEXT_XPATH)));
        Assert.assertTrue(locationText.isDisplayed(), "Location text should be visible on the dashboard");

        WebElement pricingText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRICING_TEXT_XPATH)));
        Assert.assertTrue(pricingText.isDisplayed(), "Pricing section should be visible on the dashboard");

        WebElement port1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PORT1_TEXT_XPATH)));
        Assert.assertTrue(port1.isDisplayed(), "Port 1 (Left) should be visible on the dashboard");

        WebElement port2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PORT2_TEXT_XPATH)));
        Assert.assertTrue(port2.isDisplayed(), "Port 2 (Right) should be visible on the dashboard");
    }
}
