package demoTest;

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import POM.faceBookLoginPOM;
import POM.instaLoginPOM;

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
        options.setAcceptInsecureCerts(true); // Handle security issues 🔒
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        _fbLogin = new faceBookLoginPOM(driver);
        _instaLogin = new instaLoginPOM(driver);
        FileInputStream readFile = new FileInputStream(System.getProperty("user.dir") + "\\testData\\loginTestData.java.txt");
        byte[] s = readFile.readAllBytes();
        String data = new String(s, java.nio.charset.StandardCharsets.UTF_8);
        System.out.println(data);
        readFile.close();
    }

    @Parameters({"browser", "url"})
    @Test
    public void testMethod(String url, String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver.get(url);
            // driver.quit();
        } else {
            System.out.println("Browser " + browser + " not handled");
        }
    }

    @DataProvider
    public Object[][] getDataValues() {
        return new Object[][]{
            {"user1", "password1"},
            {"user2", "password2"},
            {"admin", "admin123"},
            {"testuser", "testpass"}
        };
    }
}