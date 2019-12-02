
package framework;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameworkLocators implements WrapperClasses {
	
	
	protected WebDriver driver = new ChromeDriver();
	 protected static By username = By.xpath("//input[@placeholder = \"Enter your email address / username\" ]");
	 protected static By password = By.xpath("//input[@placeholder = \"Enter your Password\"]");
	 protected static By submit   = By.xpath("(//span[text() = 'Sign In'])[2]");	
	 protected static By home = By.xpath("//a[text() = \"Home\"]");
	 protected static By profile  = By.xpath("(//span[text() = \"BD\"])[1]");
	 protected static By settings = By.xpath("/html/body/div[2]/div/div[2]/a[1]/div/span");
	 protected static By userprofile = By.xpath("(//span[text() = \"User Profile\"])[1]");
	 protected static By phonenumber = By.xpath("//input[@placeholder=\"Enter your phone number\"]");
	 
	 
	 public void OpenBrowser(String url) {
		 System.setProperty("webdriver.chrome.driver", "E:\\Ecl\\drivers\\chromedriver_win322\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
	 }
	 
	 public  void closeBrowser() {
			WebDriver driver = new ChromeDriver();
			driver.close();
	 }
	 public void scrollDown() {
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,250)");
	 }
	 public static void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{
	        TakesScreenshot scrShot =((TakesScreenshot)driver);
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	        File DestFile=new File("E:\\JohnDeere\\screenshot");
	        FileUtils.copyFile(SrcFile, DestFile);

	    }
}
