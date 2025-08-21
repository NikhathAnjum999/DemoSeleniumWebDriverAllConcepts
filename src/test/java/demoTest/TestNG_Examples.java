package demoTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Examples {
/*
 * @Test - annotation

1) TestNG execute test methods based on alphabetical order.
2) @Test(priority=num) controls the order of execution.
3) Once you provide priority to the test methods, then order of methods is not consi dered.
4) priorities can be random numbers( no need to have consecutive numbers)
5) If you dont provide priority then default value is Zero (0).
6) If the priorties are same then again execute methods in alphabetical order.
7) Negative values are allowed in priority.
8) TestNG execute test methods only if they are having @Test annotation.

execute test cases using testing xml file

test xml file
--------

1) generate automatically
2) manually

o/p of below methoods:

I am Test BeforeSuiteMethod
I am Test BeforeTest
I am Test BeforeClass
I am Test BeforeMethod
I am Test Method
I am Test AfterMethod
I am Test AfterTest
@Test(priority=1) - executes first if no priority then before first by default priority is '0'
@Test(priority=1,dependsOnMethods={"appSetUp"})
	- if appSetUp fails then this method also fails so wont execute failed tests any how it has to fail, 

 * */
	WebDriver driver;
	@BeforeClass(groups = {"sanity"})
	public void appSetUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		driver=new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("I am Test BeforeClass");
	}
	@Test(groups = {"sanity"})
	public void test() {
System.out.println("I am Test Method");
String actualTitle="Automation Testing Practice";
String expectedTitle=driver.getTitle();
Assert.assertEquals(actualTitle, expectedTitle);
WebElement element = driver.findElement(By.xpath("//h1"));
Assert.assertTrue(element.isDisplayed());
WebElement buttonElement = driver.findElement(By.xpath("//button"));
Assert.assertFalse(buttonElement.isEnabled());
String str = null;
Assert.assertNull(str);
WebElement headingElement = driver.findElement(By.xpath("//h1"));
Assert.assertNotNull(headingElement);
String str1 = "Hello";
String str2 = "Hello";
Assert.assertSame(str1, str2);
Assert.assertNotSame(str1, str2);
SoftAssert softAssert = new SoftAssert();
softAssert.assertEquals(actualTitle, expectedTitle);
WebElement headigelement = driver.findElement(By.xpath("//h1"));
softAssert.assertTrue(headigelement.isDisplayed());
softAssert.assertAll(); // Call assertAll() at the end of the test
}

	
	@Test(groups = {"sanity"})
	public void BeforeSuiteMethod() {
		System.out.println("I am Test BeforeSuiteMethod");
		

	}
	@AfterSuite
public void AfterSuiteMethod() {
		System.out.println("I am Test AfterSuiteMethod");

	}
	@BeforeTest
	public void BeforeTest() {
		System.out.println("I am Test BeforeTest");

	}
	@AfterTest
	public void AfterTest() {
		System.out.println("I am Test AfterTest");

	}
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("I am Test BeforeMethod");

	}
	@AfterMethod
	public void AfterMethod() {
		System.out.println("I am Test AfterMethod");

	}
	@AfterSuite
	public void AfterSuite() {
		System.out.println("I am Test AfterSuite");

	}
	@Test(priority=1,dependsOnMethods={"appSetUp"})
	
	public void first_Method() {
		System.out.println("Priorty method-1");
		
	}
@Test(groups= {"sanity,regression"})
	public void first_Method1() {
		System.out.println("Priorty method-2");
		
	}
}
