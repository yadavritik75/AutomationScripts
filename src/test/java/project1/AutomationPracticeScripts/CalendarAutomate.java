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

public class CalendarAutomate {

	public static void main(String[] args) {
		String Year = "1998";
		String month = "7";
		String date = "19";
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice-automation.com/calendars/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("g1065-1-selectorenteradate")).click();
		driver.findElement(By.cssSelector("button[class*='dp-focusable dp-cal-year']")).click();
		WebElement selectYear = driver.findElement(By.xpath("//button[@data-year='" + Year + "']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", selectYear);
		selectYear.click();
		WebElement montHeader = driver.findElement(By.cssSelector("button[class*='dp-focusable dp-cal-month']"));
		montHeader.click();
		driver.findElements(By.cssSelector(".dp-month")).get(Integer.parseInt(month) - 1).click();
		driver.findElement(By.xpath("//button[text()='" + date + "']")).click(); // select Date
		driver.findElement(By.xpath("//button[@type='submit' and @class='pushbutton-wide']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement confirmationText = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("h4[id*='contact-form-success-header-d78']")));
		String actualText=confirmationText.getText();
		System.out.println(actualText);
		Assert.assertEquals("Thank you for your response.", actualText.trim());

	}

}
