package project1.AutomationPracticeScripts;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CountOfLinks {

	public static void main(String[] args) {
//		ChromeOptions options = new ChromeOptions();
//		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//count of links in the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		//count of links in the footer section
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		//count of links in the first column of the footer section
		WebElement column = footer.findElement(By.xpath("//tbody//tr//td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		//click on each link in the first column and check if the pages are opening
		for(int i=0;i<column.findElements(By.tagName("a")).size();i++)
		{
			String clickonTab=Keys.chord(Keys.CONTROL,Keys.ENTER); // to open the link in new tab
			column.findElements(By.tagName("a")).get(i).sendKeys(clickonTab);
		}
		
		//to switch to each tab and print the title of the page
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
