package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
WebDriver driver;
loginTest loginTest;
@BeforeTest
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("disable-infobars");
	WebDriver driver=new ChromeDriver(options);
	driver.get("https://www.facebook.com/");
	loginTest=new loginTest(driver);
}
@Test
public void TestMethod() {
	loginTest.userEmail("nikhath.anjum146@gmail.com");
	loginTest.userPassword("facebook523@");
	loginTest.loginButton();
}
}
