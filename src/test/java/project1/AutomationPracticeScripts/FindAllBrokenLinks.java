package project1.AutomationPracticeScripts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class FindAllBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		// Find all the links in the page and check if any link is broken
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert softAssert = new SoftAssert();
		for (WebElement link : links) 
		{
			String url = link.getDomAttribute("href");
			// Skip if the URL is null, empty, or a placeholder
			if (url == null || url.isEmpty() || url.equals("#"))
			{
				System.out.println("Skipping invalid URL: " + url);
				continue;
			}
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respcode = conn.getResponseCode();
			System.out.println(respcode);

			softAssert.assertTrue(respcode< 400,
					"The link with text " + link.getText() + " is broken with the status code : " + respcode);

		}
		softAssert.assertAll();
	}

}
