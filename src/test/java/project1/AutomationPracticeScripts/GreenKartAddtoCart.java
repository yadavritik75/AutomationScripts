package project1.AutomationPracticeScripts;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKartAddtoCart {

	public static void main(String[] args) {
		String[] producNames = { "Cucumber", "Brocolli", "Cauliflower" };
		int j=0;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> itemsNeeded = Arrays.asList(producNames);
		
		for(int i=0;i<products.size();i++)
		{
			String formattedName = products.get(i).getText().split("-")[0].trim();
			if(itemsNeeded.contains(formattedName))
			{
				j++;
				// increase the quantity to 3
				 for(int k=0; k<2; k++)
				    {
				        driver.findElements(By.xpath("//a[@class='increment']")).get(i).click();
				    }

				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if(j==producNames.length)
				{
					break;
				}
			}
			
		}
		

	}

}
