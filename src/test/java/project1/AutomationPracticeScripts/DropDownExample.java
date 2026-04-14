package project1.AutomationPracticeScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(3000);
		//For Currency
		WebElement staticDropdown=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Thread.sleep(2000);
		Select dropdown=new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		//For selecting passengers
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
		Thread.sleep(2000);
		int i=1;
		while(i<5)
		{
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
			i++;
			System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		}
		Thread.sleep(2000);
		int j=1;
		while(j<5)
		{
			driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();
			j++;
			
		}
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click(); // clicked on done button
		//For selecting Arrival & Departure city 
		driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@value='MAA']")).getText());
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_destinationStation1_CTXTaction']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='ATQ'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("(//a[@value='ATQ'])[2]")).getText());
		

	}

}
