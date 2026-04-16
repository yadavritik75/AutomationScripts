package project1.AutomationPracticeScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://vinothqaacademy.com/mouse-event/");
		List<WebElement> menus = driver.findElements(By.xpath("(//ul[@class='header-menu clearfix'])[2] /li"));
		Actions action=new Actions(driver);
		for(WebElement menu:menus) {
			action.moveToElement(menu).perform();
		}
		//double click
		WebElement dblclick = driver.findElement(By.id("doubleBtn"));
		action.doubleClick(dblclick).perform();
		System.out.println(driver.findElement(By.id("doubleStatus")).getText());
		
		//right click
		
		WebElement rightclick = driver.findElement(By.id("rightBtn"));
		action.contextClick(rightclick).perform();
		System.out.println(driver.findElement(By.id("rightStatus")).getText());
		
		//drag and drop
		WebElement source = driver.findElement(By.id("dragItem"));
		WebElement target = driver.findElement(By.id("dropZone"));
		action.dragAndDrop(source, target).perform();
		System.out.println(driver.findElement(By.id("dragStatus")).getText());
		
		//tool tip
		WebElement tip = driver.findElement(By.id("tooltipTarget"));
		action.moveToElement(tip).perform();
		System.out.println(driver.findElement(By.id("tooltipStatus")).getText());
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("sliderStatus")).getText());
		
		WebElement slider = driver.findElement(By.xpath("//div[@role='slider']"));
		action.clickAndHold(slider)
	      .moveByOffset(50, 0)
	      .release()
	      .perform();
		
		System.out.println(driver.findElement(By.id("sliderStatus")).getText());
		
		
		

	}

}

