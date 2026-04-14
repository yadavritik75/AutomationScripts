package project1.AutomationPracticeScripts;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	public static void main(String[] args) {
		
		// Array of products needed to be added to cart
		String[] producNames = { "Cucumber", "Brocolli", "Cauliflower" };
		WebDriver driver = new ChromeDriver();
		int j = 0;
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < product.size(); i++) {
			String[] name = product.get(i).getText().split("-");
			String formatedName = name[0].trim();
			//convert array to arraylist for easy search
			List itemNeeded = Arrays.asList(producNames);
			
			if (itemNeeded.contains(formatedName)) {
				j++;
				// click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();

				if (j == producNames.length) {
					break;
				}

			}

		}
	}

}
