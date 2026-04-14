package project1.AutomationPracticeScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class AssignmenetProtoCommerce {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector(".form-control.ng-pristine")).sendKeys("ritika");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("honeyritikjob75");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
		WebElement Genderdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown=new Select(Genderdropdown);
		dropdown.selectByVisibleText("Female");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		System.out.println(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());
		driver.findElement(By.name("bday")).sendKeys("02/02/1992");
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());
		Assert.assertTrue(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText().contains("Success! The Form has been submitted successfully!."));
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		
		

	}

}
