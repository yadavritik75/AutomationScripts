package project1.AutomationPracticeScripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class windowhandlingApril {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://vinothqaacademy.com/mouse-event/");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		WebElement menu = driver.findElement(By.xpath("(//li[contains(@class,'menu-item-14046')])[2]"));
		Actions action=new Actions(driver);
		action.moveToElement(menu).perform();
//		driver.findElement(By.xpath("(//li[contains(@class,'menu-item-14117')])[2]")).click(); //click cucumber BDD Framework individually
//		List<WebElement> options = driver.findElements(
//			    By.xpath("(//*[text()='Free Complete QA Video Courses'])[2]/following-sibling::ul[@class='sub-menu']//a")
//			);
//		for(int i=0;i<options.size();i++)
//		{
//			String clickonTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
//			options.get(i).sendKeys(clickonTab);
//		}
		List<WebElement> options = driver.findElements(
		    By.xpath("(//*[text()='Free Complete QA Video Courses'])[2]/following-sibling::ul[@class='sub-menu']//a")
		);
		
		for(WebElement option:options)
		{
			
			String url = option.getDomAttribute("href");
			String clickonTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			option.sendKeys(clickonTab);
			System.out.println(url);
			
		}
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		

	}

}
