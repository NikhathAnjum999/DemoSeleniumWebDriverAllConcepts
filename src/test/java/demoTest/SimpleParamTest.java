package demoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(demoTest.MyListener.class)
public class SimpleParamTest {
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String br) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		 ChromeOptions options=new ChromeOptions();
		  options.addArguments("disable-infobars");
		    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		driver=new ChromeDriver(options);
		System.out.println(br);
	}
	@Parameters({"url"})
	@Test
	public void m1(String url) {
		driver.get("https://www.facebook.com/");
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("daf@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("123@");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

	}

}
