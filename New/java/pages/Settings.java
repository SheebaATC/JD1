package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.FrameworkAllLocators;

public class Settings extends FrameworkAllLocators {

	
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
	
	

