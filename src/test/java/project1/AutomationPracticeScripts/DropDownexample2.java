package project1.AutomationPracticeScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownexample2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
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
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click(); // clicked on done button
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		
		
	}

}
