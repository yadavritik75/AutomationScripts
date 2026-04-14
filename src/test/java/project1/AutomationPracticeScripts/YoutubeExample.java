package project1.AutomationPracticeScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YoutubeExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://www.youtube.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@role='combobox']")).sendKeys("Haryanvi songs");
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		WebElement searchicon=driver.findElement(By.xpath("//*[@aria-label='Search']"));
		action.moveToElement(searchicon).click().perform();
		Thread.sleep(3000);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement videoThumbnail = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//a[@id='video-title']")
         ));
         videoThumbnail.click();
         Thread.sleep(19000);
         driver.findElement(By.xpath("//*[@aria-label='Next keyboard shortcut SHIFT+n']")).click();

	}

}