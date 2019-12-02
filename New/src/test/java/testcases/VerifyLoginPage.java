package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginLMS;
import pages.Settings;

public class VerifyLoginPage {
	
	
	WebDriver driver = null;
	@Test
	public void Verifyvalidlogin() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Ecl\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://learn-staging.auzmor.com/");
		LoginLMS.enterUsername(driver, "balakrishnan@american-technology.net");
		LoginLMS.enterpassword(driver, "ATCTech123!");
		LoginLMS.submit(driver).click();
		Thread.sleep(3000);
		HomePage.clickHome(driver).click();
		HomePage.clickProfile(driver).click();
		HomePage.clickSettings(driver).click();
		System.out.println("Homepage");
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,3500)");
		//scrollDown();
		Settings.userProfile(driver).click();
		Settings.phoneNumber(driver, "123456789");
		System.out.println("Profile");
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshotFile, new File("C:\\Users\\User\\eclipse-workspace\\framework\\Screenshot\\snippet.jpg"));
		 
		 
		 
		 driver.close();
	}
	
		
	
}
