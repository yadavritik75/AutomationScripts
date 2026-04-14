package project1.AutomationPracticeScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownload {

	public static void main(String[] args) {
		String fruitName="Kivi";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		//downloading the file
		driver.findElement(By.cssSelector("#downloadButton")).click();
		//Upload the file 
		WebElement upload = driver.findElement(By.cssSelector("#fileinput"));
		upload.sendKeys("C:\\Users\\Ritik\\Downloads\\download.xlsx");
		//Wait for the toast message to appear and verify it
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
		By message=By.xpath("//div[text()='Updated Excel Data Successfully.']");
		//Wait for the toast message to appear and print it
		wait.until(ExpectedConditions.visibilityOfElementLocated(message));
		
		//Get the toast message text and assert it
		String toastText=driver.findElement(message).getText();
		System.out.println("Toast Message: "+toastText);
		Assert.assertEquals("Updated Excel Data Successfully.",toastText);
		//Wait for the toast message to disappear 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(message));
		//Get the column name of the price column
		String columnName = driver.findElement(By.xpath("//div[@id='cell-4-undefined']")).getDomAttribute("data-column-id");
		//Get the price of the fruit and assert it
		String actualPrice=driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+columnName+"-undefined']")).getText();
		Assert.assertEquals("399",actualPrice);
		
		

	}

}
