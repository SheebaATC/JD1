package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends framework.FrameworkAllLocators{

	
	//Home screen
	
private static WebElement element = null;

	public static WebElement clickHome(WebDriver driver) {
		element = driver.findElement(home);
		return element;
	}
	public static WebElement clickProfile(WebDriver driver) {
		element = driver.findElement(profile);
		return element;
		
	}
	public static WebElement clickSettings(WebDriver driver) {
		element  = driver.findElement(settings);
		return element;
	}
}
