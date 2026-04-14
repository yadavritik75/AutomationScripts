package project1.AutomationPracticeScripts;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart2 {

	public static void main(String[] args) {
		// items needed to be added in the cart
		String itemsNeeded[] = { "Cucumber", "Brocolli", "Beetroot" };
		int j = 0;
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));

		List<WebElement> AllProducts = driver.findElements(By.cssSelector("h4.product-name"));

		// convert array into arraylist
		List<String> listNeeded = Arrays.asList(itemsNeeded);

		for (int i = 0; i < AllProducts.size(); i++) {
			// split the name of the product and get only the name without quantity
			String[] name = AllProducts.get(i).getText().split("-");
			String formattedName = name[0].trim();

			if (listNeeded.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
        //click to Cart icon
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
		// click to Proceed to checkout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='PROCEED TO CHECKOUT']")));
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElements(By.cssSelector("tr td p.product-name"))
				.forEach(product -> System.out.println(product.getText()));
		// Apply Promo code and place order
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Apply']")));
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		System.out.println(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		// Select country and proceed
		WebElement countryDropDown = driver.findElement(By.tagName("select"));
		Select select = new Select(countryDropDown);
		select.selectByVisibleText("India");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	}

}
