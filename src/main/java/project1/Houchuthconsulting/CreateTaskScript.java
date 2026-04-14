package project1.Houchuthconsulting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTaskScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		// FOR LOGIN
		driver.get("https://smalsusinfolabs.sharepoint.com/sites/HHHHQA/SP/SitePages/CreateTask.aspx");
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ritik.yadav@SmalsusInfolabs.onmicrosoft.com");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Z%314263126535ac");
	    //Explicit wait for specific 
	    WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
	    w.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	    driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	    // FOR Create Task 
	    driver.findElement(By.xpath("//input[@placeholder='Enter task Name']")).sendKeys("Test Task");
	    driver.findElement(By.xpath("(//span[@title='Component Popup'])[1]")).click();
	    driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    driver.findElement(By.xpath("(//span[@title='Component Popup'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    driver.findElement(By.xpath("(//a[@class='text-decoration-none'])[5]")).click();
	    driver.findElement(By.xpath("//span[text()='Immediate']")).click();
	    driver.findElement(By.xpath("//span[text()='Draft']")).click();
	    driver.findElement(By.xpath("//span[text()='Approval']")).click();
	    driver.findElement(By.xpath("//a[text()='10']")).click();
	    driver.findElement(By.xpath("//a[text()='Very Quick']")).click();
	    driver.findElement(By.xpath("//a[text()='Tomorrow']")).click();
	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    Thread.sleep(3000);
	    //driver.findElement(By.xpath("button[class='btn btn-primary mx-1 px-3']")).click();
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    

	}

}
