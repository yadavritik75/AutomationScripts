package project1.AutomationPracticeScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlockGeoloctions {

	public static void main(String[] args) {
		ChromeOptions optionS=new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.geolocation", 1);
		optionS.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(optionS);
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/AutoComplete.html");
		

	}

}
