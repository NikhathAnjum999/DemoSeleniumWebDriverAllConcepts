package demoTest;


import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignments {
/*

Assignment -1 
----------
https://testautomationpractice.blogspot.com/

1) provide some string search for it
2) count number of links
3) click on each link using for loop
4) get window ID's for every browser window
5) close specific browser window
 * */
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUpMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		 driver=new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}
//	@Test
	public void firstAssignment() {
		driver.findElement(By.xpath("//input[@class='wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='wikipedia-search-result-link']/a")));
		List<WebElement> listElements=driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a"));
		System.out.println(listElements.size()+"Hello");
		int count=0;
		Set<String> Ids=null;
		if(!listElements.isEmpty()) {
		for(WebElement list:listElements) {
			System.out.println(list.getText());
			count++;
			list.click();
			Ids=driver.getWindowHandles();
		}
		}
		System.out.println("The count is:"+count+"\t"+Ids.size());
		for(String id:Ids) {
			driver.switchTo().window(id);
//			System.out.println(id+"I am browser ID"+driver.getTitle());
			if(driver.getTitle().equals("Testing Practice")) {
				driver.close();
			}
			
		}
	}
//	@Test
	public void scndAssigment() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://ui.vision/demo/webtest/frames/");
			driver.manage().window().maximize();
		WebElement frame=driver.findElement(By.xpath("//frame[@src=\"frame_5.html\"]"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Frame5");
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		System.out.println(driver.getTitle()+"I am fram5 title");
		
		
	}
//	@Test
	public void thirdAssignmentDynamicPagination() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
		////div[@class="orangehrm-container"]//div[@class="oxd-table-card"]
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		int paginationButtonList=
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"orangehrm-bottom-container\"]//nav//ul//li//button"))).size();
	for(int i=0;i<paginationButtonList;i++) {
		List<WebElement> pageButtons=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"orangehrm-bottom-container\"]//nav//ul//li//button")));
		if(i<pageButtons.size() && pageButtons.get(i).getText().matches("\\d+")) {
			pageButtons.get(i).click();
			List<WebElement> lists=driver.findElements(By.xpath("//div[@class=\"orangehrm-container\"]//div[@class=\"oxd-table-body\"]//div[@class=\"oxd-table-card\"]"));
			for(WebElement list:lists) {
				System.out.println(list.getText()+"\t");
			}
		}
		
	}
	}
//	@Test
	public void fourthAssignment() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://www.google.com/");
		 WebDriverWait wait=new WebDriverWait(driver,30);
		 WebElement searchElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@title='Search']")));
		 searchElement.sendKeys("Selenium");
		 List<WebElement> searchList=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"OBMEnb\"]//ul//li")));
//				 driver.findElements(By.xpath("//div[@class=\"OBMEnb\"]//ul//li"));
		 System.out.println(searchList.size());
		 for(int i=0;i<searchList.size();i++) {
			 System.out.println(searchList.get(i).getText()+"\t");
		 }
	}
	//@Test
	public void fifthAssignment() {
		//datepicker without dropdown
		String expectedMonth="August";
		String expectedYear="2025";
		String expectedDate="23";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		while(true) {
			String actualMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String actualYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(actualMonth.equals(expectedMonth) && expectedYear.equals(actualYear)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tr//td//a"));
		for(WebElement date:dates) {
			if(date.getText().equals(expectedDate)) {
				date.click();
				break;
				
			}
		}
	}
	@Test
	public void datePicker_Test() {
		String expectedMonth="August";
		String expectedYear="2025";
		String expectedDate="23";
		driver.findElement(By.xpath("//input[@id=\"txtDate\"]")).click();
		//select month using drop down
		WebElement month=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select selectMonth=new Select(month);
		List<WebElement> montOptions=selectMonth.getOptions();//reqiured when you want to iterate the month list
		selectMonth.selectByVisibleText("Jan");
		//select year
		WebElement year=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select selectYear=new Select(year);
		selectYear.selectByVisibleText("2024");
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tr//td//a"));
		for(WebElement date:dates) {
			if(date.getText().equals(expectedDate)) {
				date.click();
			}
		}
		
	}
}


