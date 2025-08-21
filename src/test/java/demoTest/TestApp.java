package demoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestApp {
@Test
	public void openApp() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		 
			WebDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://testautomationpractice.blogspot.com/");
			String title=driver.getTitle();
			if(title.equals("Automation Testing Practice")) {
//			assertEquals(true, "Success by matching correct Title");
				System.out.println("Success");
			}
			else {
				System.out.println("Fail");
			}
	}

}
