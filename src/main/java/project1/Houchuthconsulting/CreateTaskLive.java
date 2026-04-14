package project1.Houchuthconsulting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTaskLive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hhhhteams.sharepoint.com/sites/HHHH/SP/SitePages/CreateTask.aspx");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ritik.yadav@hochhuth-consulting.de");
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("1z*G4m85a");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='idSIButton9']")));
		driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter task Name']")).sendKeys("Test Task");
		driver.findElement(By.xpath("(//span[@title='Component Popup'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='search'])[6]")).sendKeys("test");
		driver.findElement(By.xpath("(//input[@type='checkbox'])[17]")).click();
		driver.findElement(By.xpath("(//span[@title='Component Popup'])[2]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("test");
		driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
		
		
	}

}
