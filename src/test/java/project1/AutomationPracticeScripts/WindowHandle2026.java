package project1.AutomationPracticeScripts;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle2026 {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	driver.findElement(By.id("openwindow")).click();
	//Window Handling
	Set<String> window = driver.getWindowHandles();
	Iterator<String> it = window.iterator();
	String parentWindow = it.next();
	String childWindow = it.next();
	driver.switchTo().window(childWindow);
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='qaclickacademy.com']")));
	
	System.out.println(driver.findElement(By.xpath("//div[text()='qaclickacademy.com']")).getText());
	
	//Table Handling
	driver.switchTo().window(parentWindow); // again switch to parent window
	driver.findElement(By.id("opentab")).click();
	Set<String> window1 = driver.getWindowHandles();
	Iterator<String> it1 = window1.iterator();
	String parentWindow1 = it1.next();
	String childWindow1 = it1.next();
	driver.switchTo().window(childWindow1);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h1")));
	System.out.println(driver.findElement(By.xpath("//div/h1")).getText());
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
