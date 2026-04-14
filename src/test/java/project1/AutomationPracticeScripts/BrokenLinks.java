package project1.AutomationPracticeScripts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getDomAttribute("href");
		HttpURLConnection conn	=(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		if(respCode>400)
		{
			System.out.println("The link is broken with the status code : "+respCode);
		}
		else
		{
			System.out.println("The link is valid with the status code : "+respCode);
		}
	}

}
