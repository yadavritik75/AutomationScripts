//package project1.Houchuthconsulting;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.Duration;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Smalsus {
//
//	public static void main(String[] args) throws IOException {
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.instagram.com/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File Destination = new File("C:\\Users\\amitk\\eclipse-workspace\\Houchuthconsulting\\");
//		org.openqa.selenium.io.FileHandler.copy(src, Destination);
//		
//		
//		
//
//	}
//
//}
package project1.AutomationPracticeScripts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Smalsus {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
        Thread.sleep(3000);

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\amitk\\eclipse-workspace\\Houchuthconsulting\\screenshot.png")) {
            fos.write(screenshotBytes);
        }
        Thread.sleep(3000);

        driver.quit();
    }
}

