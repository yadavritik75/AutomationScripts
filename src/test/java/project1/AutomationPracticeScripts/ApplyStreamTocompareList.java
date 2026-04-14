package project1.AutomationPracticeScripts;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ApplyStreamTocompareList {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//click on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//capture all webelement into list
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		//elements.stream().forEach(s->System.out.println(s.getText())); // This will give the fruitName only Not in the list
		List<String> OriginalList = elements.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println("OriginalList: "+OriginalList); // This will give the fruitName in the list
		
		//sort the list of step 3 -> sorted list
		List<String> sortedList = OriginalList.stream().sorted().collect(Collectors.toList());
		System.out.println("SortedList: "+sortedList); // This will give the fruitName in the list
		
		//compare original list vs sorted list
		Assert.assertTrue(OriginalList.equals(sortedList));
		
		
		

	}

}
