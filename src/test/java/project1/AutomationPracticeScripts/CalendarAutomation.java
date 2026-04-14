package project1.AutomationPracticeScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarAutomation {

	public static void main(String[] args) {
		String Month="7";
		String Date="20";
		String Year="2024";
		String[] expectedList= {Month,Date,Year};
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector(".react-date-picker.react-date-picker--closed.react-date-picker")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.xpath("//button[text()='" + Year + "']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(Month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='" + Date + "']")).click();
		//System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getText());
		
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		//print the actual list and compare with expected list
		for(int i=0;i<actualList.size();i++)
		{
			System.out.println(actualList.get(i).getDomAttribute("value"));
			Assert.assertEquals(actualList.get(i).getDomAttribute("value"), expectedList[i]);
			
		}
		driver.close();
		
		
		

	}

}
