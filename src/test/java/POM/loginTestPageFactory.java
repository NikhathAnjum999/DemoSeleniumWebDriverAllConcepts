package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTestPageFactory {
WebDriver driver;
loginPageFactory loginPF;
@BeforeTest
public void setUpforLoginPF() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("disable-infobars");
	WebDriver driver=new ChromeDriver(options);
	driver.get("https://www.facebook.com/");
	loginPF=new loginPageFactory(driver);
}
@Test
public void loginPF() {
	loginPF.sendEmail("nikath.anjum146@gmail.com");
	loginPF.sendPassword("Sadaf523@");
	loginPF.loginButton();
}
}
