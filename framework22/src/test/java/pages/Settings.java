package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Settings extends framework.FrameworkAllLocators {

	
	public static WebElement element = null;
	
	public static WebElement userProfile(WebDriver driver) {
		element  = driver.findElement(userprofile);
		return element;
	}
	public static WebElement phoneNumber(WebDriver driver, String string) {
		element  = driver.findElement(phonenumber);
		element.sendKeys(string);
		return element;
	}
	
	
	
}
	
	

