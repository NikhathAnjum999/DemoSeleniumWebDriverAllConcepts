package POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(demoTest.MyListener.class)
public class AppsLoginExample {
	WebDriver driver;
	faceBookLoginPOM _fbLogin;
	instaLoginPOM _instaLogin;
	@BeforeTest
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("disable-infobars");
	    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	    options.setExperimentalOption("useAutomationExtension", false);
		driver=new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		_fbLogin=new faceBookLoginPOM(driver);
		_instaLogin=new instaLoginPOM(driver);
		FileInputStream readFile = new FileInputStream(System.getProperty("user.dir") + "\\testData\\loginTestData.java.txt");
		byte[] s = readFile.readAllBytes();
		String data = new String(s, java.nio.charset.StandardCharsets.UTF_8);
		System.out.println(data);
		readFile.close();
	}

//	@Test(dataProvider="getDataValues")
	public void testFBAppLogin(String username,String password) {
		driver.get("https://www.facebook.com/");
		_fbLogin.loginToFaceBook(username,password);
	}
//	@Test(groups={"sanity","regression"})
	public void testINSTAAppLogin() {
		driver.get("https://www.instagram.com/");
		_instaLogin.loginInstagram("sadaf@gmail.com","1234");
	}

//	@Test
//	@Parameters({"browser","url"})
	public void testMehtod(String url,String browser) {

		 if (browser.equalsIgnoreCase("chrome")) { // Use .equalsIgnoreCase
			 ChromeOptions options = new ChromeOptions();
			    options.addArguments("disable-infobars");
			    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
			    options.setExperimentalOption("useAutomationExtension", false);
			    options.setAcceptInsecureCerts(true);
				driver=new ChromeDriver(options);

//		        driver.get(url);
				driver.get("https://google.com/");
//		        driver.quit(); // Don't forget to quit 🚮
		    } else {
		        System.out.println("Browser " + browser + " not handled");
		    }

	}
@Test
	public void SS_Test() {
		TakesScreenshot testSS=(TakesScreenshot)driver;
		File sourceFile=testSS.getScreenshotAs(OutputType.FILE);
		File targetFile=new File(System.getProperty("user.dir")+"//screenshots//hybridSS1.png");
		sourceFile.renameTo(targetFile);
		WebElement ele=driver.findElement(By.tagName("p"));
		File sourceFIle=ele.getScreenshotAs(OutputType.FILE);
		File targetFIle=new File(System.getProperty("user.dir")+"//screenshots//eleSS1.png");
		sourceFIle.renameTo(targetFIle);
	}
	@DataProvider
	public Object[][] getDataValues() {
	    return new Object[][] {
	        {"user1", "password1"},
	        {"user2", "password2"},
	        {"admin", "admin123"},
	        {"testuser", "testpass"}
	    };
	}
}

