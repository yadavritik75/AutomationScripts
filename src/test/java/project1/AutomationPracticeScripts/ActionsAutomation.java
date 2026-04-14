package project1.AutomationPracticeScripts;

import java.time.Duration;import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAutomation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement move = driver.findElement(By.cssSelector(".icp-nav-link-inner"));
		Actions action=new Actions(driver);
		action.moveToElement(move).perform();
		WebElement move1 = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		action.moveToElement(move1).perform();
		WebElement move3 = driver.findElement(By.id("twotabsearchtextbox"));
		
		action.moveToElement(move3).click().keyDown(Keys.SHIFT).sendKeys("laptop").keyUp(Keys.SHIFT).build().perform();
		
		action.moveToElement(move3).doubleClick().perform();
		move3.clear();
		
		action.moveToElement(move3).click().sendKeys("tablet").perform();
		action.moveToElement(move3).click().doubleClick().perform();
		Thread.sleep(2000);
		action.moveToElement(move3).contextClick().perform();
		
		
		
		
		
		
		

	}

}
