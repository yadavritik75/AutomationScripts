package project1.AutomationPracticeScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Autofilled {

	public static void main(String[] args) {
		//Run the test in incognito mode
		ChromeOptions optionS=new ChromeOptions();
		optionS.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(optionS);
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/AutoComplete.html");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		driver.findElement(By.id("searchbox")).sendKeys("bra");
		List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item"));
		for (WebElement option : options) {
			if (option.getText().equals("Brazil")) {
				option.click();
				break;
			}
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='SwitchTo']"))).perform();
		driver.findElement(By.xpath("//a[text()='Alerts']")).click();

	}

}
