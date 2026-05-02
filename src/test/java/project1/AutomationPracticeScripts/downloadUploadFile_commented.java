package project1.AutomationPracticeScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * downloadUploadFile_commented
 *
 * A commented, easy-to-follow variant of the original `downloadUploadFile`.
 * This class demonstrates the same actions but includes descriptive
 * documentation and inline comments to explain each Selenium pattern used.
 *
 * Use this file as a learning reference or replace the original file with
 * the contents below in your IDE.
 */
public class downloadUploadFile_commented {

    public static void main(String[] args) {
        // Create the Chrome WebDriver. Ensure chromedriver is available on PATH
        // or managed by your preferred WebDriver manager.
        WebDriver driver = new ChromeDriver();

        try {
            // STEP 1: Open the target site and maximize the browser window.
            // Maximizing helps avoid layout-related differences (mobile vs desktop)
            // that can cause elements to be hidden or non-clickable.
            driver.get("https://practice-automation.com/");
            driver.manage().window().maximize();

            // Implicit wait: a short global wait as a safety net. Prefer explicit
            // waits for specific element conditions (used below) to make tests
            // deterministic and less flaky.
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Explicit wait object used for element-specific conditions such as
            // elementToBeClickable and visibilityOfElementLocated.
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // STEP 2: Navigate to the 'file-download' page.
            // Use a CSS selector that finds links where the href contains
            // 'file-download'. We wait until the element is clickable before
            // interacting to avoid timing issues.
            WebElement downloadButton = wait
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='file-download']")));

            // Some pages have overlays or non-standard markup that prevents
            // Selenium's native click() from working reliably. Executing a
            // JavaScript click triggers the DOM click handler directly.
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", downloadButton);

            // On the file-download page, click the first "Download" link. This
            // will trigger the browser's download behavior. Note: this example
            // does not perform a filesystem check to confirm the file arrived.
            driver.findElement(By.xpath("(//a[text()='Download'])[1]")).click();

            // STEP 3: Return to the home page.
            // Clicking the "Home" link brings us back so we can go to the
            // upload page in the next step.
            driver.findElement(By.xpath("//a[text()='Home']")).click();

            // STEP 4: Navigate to the 'file-upload' page and upload a file.
            WebElement uploadButton = wait
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='file-upload']")));

            // Use JS click again for robustness (same reason as before).
            js.executeScript("arguments[0].click();", uploadButton);

            // Locate the <input type="file"> element. File inputs are special in
            // that you set the file path via sendKeys; you don't interact with
            // the native OS dialog in Selenium.
            WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));

            // IMPORTANT: The following uses an absolute path pointing to the
            // user's Downloads folder. For tests that run on multiple machines
            // or CI, prefer storing test files in the project (e.g.,
            // src/test/resources) and building the absolute path dynamically.
            uploadFile.sendKeys("C:\\Users\\Ritik\\Downloads\\test.pdf");

            // Submit the upload form by clicking the upload button.
            driver.findElement(By.id("upload-btn")).click();

            // STEP 5: Wait for and verify the confirmation message.
            // The selector ".wpcf7-response-output" is used by the page to show
            // a success/failure message after form submission.
            String confirmText = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".wpcf7-response-output")))
                    .getText();

            // Assert the expected confirmation text. If the site's message
            // changes frequently, use a contains() check or regex instead to
            // make the assertion more resilient.
            Assert.assertEquals(confirmText, "Thank you for your message. It has been sent.");

        } finally {
            // ALWAYS quit the WebDriver session to clean up browser processes.
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
