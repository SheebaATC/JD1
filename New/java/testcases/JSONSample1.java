package testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bsh.ParseException;
import pages.HomePage;
import pages.LoginLMS;
import pages.Settings;

public class JSONSample1 {	
	static WebDriver driver;

	public static void beforeTest() throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\Ecl\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://learn-staging.auzmor.com/");
		System.out.println("BeforeTest");
	}

	@Test
	public void testAut() throws InterruptedException, IOException,  org.json.simple.parser.ParseException, ParseException {
		readWriteJSON();
		System.out.println("Test");
	}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.quit();
		System.out.println("AfterTest");
		Thread.sleep(3000);
	}

	@SuppressWarnings("unlikely-arg-type")
	public static String login(String username1, String password1) throws InterruptedException, IOException {
		beforeTest();
		LoginLMS.enterUsername(driver, username1);
		LoginLMS.enterpassword(driver, password1);
		Thread.sleep(3000);
		LoginLMS.submit(driver).click();
		System.out.println("LoggedIn");
		Thread.sleep(3000);
		String valid = "Valid user";
		String invalid = "InValid user";
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		try
		{
			if(currentUrl.equals("https://learn-staging.auzmor.com/"))
			{
				Verifyvalidlogin();			
			}else
			{
				return invalid;
			}
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		return valid;


	}


	public static void Verifyvalidlogin() throws InterruptedException, IOException {
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
	}

	@SuppressWarnings("unchecked")
	public void readWriteJSON() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
		JSONParser jsonParser = new JSONParser();
		try  {
			FileReader reader = new FileReader("C:\\Users\\User\\eclipse-workspace\\framework2\\src\\test\\java\\pages\\JSONData.json");
			Object obj = jsonParser.parse(reader);
			JSONArray usersList = (JSONArray) obj;
			System.out.println("Users List-> "+usersList); //This prints the entire json file
			for(int i=0;i<usersList.size();i++) {
				JSONObject users = (JSONObject) usersList.get(i);
				System.out.println("Users -> "+users);//This prints every block - one json object
				JSONObject user = (JSONObject) users.get("users");
				System.out.println("User -> "+user); //This prints each data in the block
				String username1 = (String) user.get("username");
				System.out.println(username1);
				String password1 = (String) user.get("password");
				System.out.println(password1);
				String result = login(username1,password1);
				driver.close();
				System.out.println(result);
				user.put("result", result);
				//Write JSON file
				try (FileWriter file = new FileWriter("Testdata1.json")) {
					file.append(usersList.toJSONString());
					file.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(user);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}







}
