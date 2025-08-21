
package demoTest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class DataProviderExample {
	WebDriver driver;
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String br) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		 ChromeOptions options=new ChromeOptions();
		  options.addArguments("disable-infobars");
		  System.out.println(br+"BROWSER");
		    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		    if(br.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver(options);
		    }
		   
	}
//@Test(dataProvider="dp")
public void loginApp(String emailData,String passwordData) {

	driver.get("https://www.facebook.com/");
	WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
	email.sendKeys(emailData);
	WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
	password.sendKeys(passwordData);
	driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	String actualResult="Facebook";
	String title=driver.getTitle();
	Assert.assertEquals(actualResult, title);
}


@Test
public void testMethod() {
	System.out.println("Test");
	driver.get("https://testautomationpractice.blogspot.com/");
}
@DataProvider(name="dp")
Object[][] logindata(){
	Object data[][]= {
			{"sadaf@gmail.com","facebook523@"},

			{"nikhath@gmail.com","nikanj523@"},
			{"nikhath.anjum146@gmail.com","Sadaf523@"}
	};
	return data;
}


}
