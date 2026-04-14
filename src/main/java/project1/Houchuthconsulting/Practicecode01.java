package project1.Houchuthconsulting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practicecode01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.shoppersstack.com/products_page/17");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='loginBtn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Email")).sendKeys("abcde@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("Password")).sendKeys("123456789@");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span.MuiButton-label")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Forgot Password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("honeyritikjob75@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("contact us")).click();
		
		
		

	}

}
