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

public class downloadUploadFile {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice-automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement downloadButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='file-download']")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", downloadButton);
		driver.findElement(By.xpath("(//a[text()='Download'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		WebElement uploadButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='file-upload']")));

		js.executeScript("arguments[0].click();", uploadButton);
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFile.sendKeys("C:\\Users\\Ritik\\Downloads\\test.pdf");
		driver.findElement(By.id("upload-btn")).click();
		
		String confirmText=wait
		.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".wpcf7-response-output"))).getText();
		Assert.assertEquals(confirmText, "Thank you for your message. It has been sent.");
		System.out.println(confirmText);

	}

}
