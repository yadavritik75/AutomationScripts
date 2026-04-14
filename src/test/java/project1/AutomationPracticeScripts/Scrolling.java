package project1.AutomationPracticeScripts;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Run chrome in headless mode
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		// Scrolling by pixel
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		// scrolling by element inside the page
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        // Get the list of all the numbers in the table 
		List<WebElement> Lnumbers = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int sum = 0;
		for (int i = 0; i < Lnumbers.size(); i++) {
			System.out.println(Lnumbers.get(i).getText());

			// convert string to integer

			sum = sum + Integer.parseInt(Lnumbers.get(i).getText());

		}

		System.out.println("Total sum :" + sum);
		// Get the total amount from the page and compare it with the sum of the numbers
		String total = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		System.out.println("Total amount :" + total);

		if (total.equalsIgnoreCase(Integer.toString(sum))) {
			System.out.println("Total amount matches with the sum of the numbers");
		} else {
			System.out.println("Total amount does not match with the sum of the numbers");
		}
		// How to take screenshot in Selenium WebDriver
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File(System.getProperty("user.dir") + "//reports//Screenshot.png");
//		FileUtils.copyFile(source, dest);

	}

}
