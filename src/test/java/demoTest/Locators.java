package demoTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
/*
 Selenium WebDriver: Browser automation tool
WebDriver Interface: Interface for browser interactions
WebElement Interface: Interface for HTML element interactions
By Class: Locator strategies for finding elements

Locator Strategies
ID
Name
ClassName
TagName
LinkText
PartialLinkText
CSS
XPath

WebDriver Methods
get(): Navigate to a URL
getTitle(): Get the page title
getPageSource(): Get the page source code
close(): Close the browser
quit(): Quit the driver instance
manage(): Manage browser settings (e.g., timeouts, window size)
findElement(): Find a single element
findElements(): Find multiple elements

WebElement Methods
click(): Click an element
sendKeys(): Send keys to an element (e.g., text input)
getText(): Get the text of an element
getAttribute(): Get an attribute value of an element
getCssValue(): Get a CSS property value of an element
isEnabled(): Check if an element is enabled
isSelected(): Check if an element is selected
isDisplayed(): Check if an element is displayed
methods:
============================================
Here are some common WebDriver methods:
Navigation Methods
driver.get(url): Navigate to a URL.
driver.navigate().to(url): Navigate to a URL.
driver.navigate().back(): Go back to the previous page.
driver.navigate().forward(): Go forward to the next page.
driver.navigate().refresh(): Refresh the current page.
Element Locator Methods
driver.findElement(By locator): Find a single element on the page.
driver.findElements(By locator): Find multiple elements on the page.
Element Interaction Methods
element.click(): Click on an element.
element.sendKeys(text): Send text to an element (e.g., input field).
element.clear(): Clear the text in an element.
element.submit(): Submit a form.
Element Information Methods
element.getText(): Get the text of an element.
element.getAttribute(name): Get the value of an attribute.
element.isDisplayed(): Check if an element is displayed.
element.isEnabled(): Check if an element is enabled.
element.isSelected(): Check if an element is selected.
Window and Frame Methods
driver.switchTo().window(windowHandle): Switch to a different window.
driver.switchTo().frame(frameNameOrIndex): Switch to a frame.
driver.switchTo().defaultContent(): Switch back to the default content.
Alert Methods
driver.switchTo().alert().accept(): Accept an alert.
driver.switchTo().alert().dismiss(): Dismiss an alert.
driver.switchTo().alert().getText(): Get the text of an alert.
Other Methods
driver.getTitle(): Get the title of the current page.
driver.getCurrentUrl(): Get the URL of the current page.
driver.quit(): Close the browser and terminate the session.
driver.close(): Close the current window.
These are just some of the many methods available in WebDriver. The specific methods you use will depend on your testing needs.

automation of this link="https://testautomationpractice.blogspot.com/"
 * */
public class Locators {
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void allLocatorsTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement firstName=driver.findElement(By.xpath("//input[@id='name']"));
		firstName.sendKeys("Nikhath Anjum");
		WebElement emailId=driver.findElement(By.xpath("//input[@id='email']"));
		emailId.sendKeys("nikhat.software@gmail.com");
		WebElement phone=driver.findElement(By.xpath("//input[@id='phone']"));
		phone.sendKeys("9100650928");
		WebElement address=driver.findElement(By.xpath("//textarea[@id='textarea']"));
		address.sendKeys("7-3-149,Kashmeergadda,Karimnagar,505001.");
		driver.findElement(By.id("female")).click();//female radio button
		String[] days=new String[] {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
		for(String day:days) {
			WebElement checkBoxTest=driver.findElement(By.id(day));
			checkBoxTest.click();
		}
		WebElement countryDrpDown=driver.findElement(By.id("country"));
	countryDrpDown.click();
	Select  selectDrpDown=new Select(countryDrpDown);
	selectDrpDown.selectByValue("india");
	WebElement colorDrpDown=driver.findElement(By.id("colors"));
	Select selectClrDrpDown=new Select(colorDrpDown);
	selectClrDrpDown.selectByIndex(4);
	WebElement animals=driver.findElement(By.id("animals"));
	Select animalDrpDown=new Select(animals);
	animalDrpDown.selectByVisibleText("Lion");
	WebElement testName=driver.findElement(By.id("datepicker"));
testName.sendKeys("08/08/2025");
driver.findElement(By.xpath("//input[@id='txtDate']")).click();

String reqiuredMonth="Feb";
String reqiuredYear="2024";
String dateReqiured="12";
//ui-datepicker-month
WebElement currentMonth=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
Select selectMonth=new Select(currentMonth);
selectMonth.selectByVisibleText(reqiuredMonth);
WebElement currentYear=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
Select selectYear=new Select(currentYear);
selectYear.selectByVisibleText(reqiuredYear);
List<WebElement> dates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td//a"));
for(WebElement date:dates) {
	System.out.println(date.getText());
	if(dateReqiured.equals(date.getText())) {
		date.click();
	}
}
////input[@id='singleFileInput']
WebElement uploadFile=driver.findElement(By.xpath("//input[@id='singleFileInput']"));
//uploadFile.click();

uploadFile.sendKeys("C:\\Users\\nikha\\OneDrive\\Pictures\\Screenshots\\selenium ALl\\singleonLogger.txt");
driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']")).submit();

//DeletingFIles
WebElement uploadFiles=driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
String[] fileArray={"C:\\Users\\nikha\\OneDrive\\Pictures\\Screenshots\\selenium ALl\\singleonLogger.txt","C:\\Users\\nikha\\OneDrive\\Pictures\\Screenshots\\selenium ALl\\DeletingFIles.txt"};
uploadFiles.sendKeys(String.join("\n", fileArray));
driver.findElement(By.xpath("//button[normalize-space()='Upload Multiple Files']")).submit();
WebElement bookTable=driver.findElement(By.name("BookTable"));

List<WebElement> tableRow=bookTable.findElements(By.tagName("tr"));
for(WebElement row:tableRow) {
	List<WebElement> data=row.findElements(By.tagName("td"));
	for(WebElement d:data) {
		System.out.print(d.getText()+"\t"+"|");
	}
	System.out.println();
	
}
List<WebElement> pages = driver.findElements(By.xpath("//ul[@class='pagination']//li//a"));
for (WebElement p : pages) {
    System.out.println(p.getText());
    p.click();
    
    // Re-find table and rows after navigating to page
    WebElement table = driver.findElement(By.id("productTable"));
    List<WebElement> rows = table.findElements(By.tagName("tr"));
    for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        for (WebElement cell : cells) {
            System.out.print(cell.getText() + " | ");
        }
        System.out.println();
    }
}
		

driver.findElement(By.className("wikipedia-search-input")).sendKeys("Selenium");
driver.findElement(By.className("wikipedia-search-button")).click();
List<WebElement> listData=driver.findElements(By.id("Wikipedia1_wikipedia-search-results"));
for(WebElement list:listData) {
	System.out.println(list.getText()+"\t");
}
Alert alert ;
WebElement alertButton=driver.findElement(By.id("alertBtn"));
alertButton.click();
alert= driver.switchTo().alert();
System.out.println(alert.getText());
alert.accept();
WebElement alertConfirmationButton=driver.findElement(By.id("confirmBtn"));
alertConfirmationButton.click();
alert= driver.switchTo().alert();
System.out.println(alert.getText());
alert.accept();
//promptBtn
WebElement promptBtn=driver.findElement(By.id("promptBtn"));
promptBtn.click();
alert= driver.switchTo().alert();
Thread.sleep(10);
alert.sendKeys("Nikhath");
Thread.sleep(50);
System.out.println(alert.getText());
alert.accept();
driver.findElement(By.id("PopUp")).click();
Set<String> getTiltle=driver.getWindowHandles();
for(String title:getTiltle) {
	 driver.switchTo().window(title);
String t=driver.getTitle();
System.out.println(t);
}

WebElement dropbtn=driver.findElement(By.className("dropbtn"));
Actions actions=new Actions(driver);
actions.moveToElement(dropbtn).build().perform();
WebElement firstLink=driver.findElement(By.linkText("Mobiles"));
WebElement scndLink=driver.findElement(By.partialLinkText("Lapt"));
actions.moveToElement(firstLink).build().perform();
actions.moveToElement(scndLink).build().perform();
WebElement copyLink=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
actions.doubleClick(copyLink).perform();
WebElement dragButton=driver.findElement(By.id("draggable"));
WebElement dropButton=driver.findElement(By.id("droppable"));
actions.dragAndDrop(dragButton, dropButton).perform();

WebElement comboBox=driver.findElement(By.id("comboBox"));
comboBox.click();
List<WebElement> dropdownList=driver.findElements(By.id("dropdown"));
for(WebElement listDrpDown:dropdownList) {
	if(listDrpDown.getText().contains("Item 1")) {
		comboBox.sendKeys(listDrpDown.getText());
		
	}
}
List<WebElement> links = driver.findElements(By.tagName("a"));
System.out.println("Number of Links: " + links.size());
driver.navigate().to("https://www.google.com/");
System.out.println(driver.getCurrentUrl());
driver.navigate().back();
System.out.println(driver.getCurrentUrl());
driver.navigate().forward();
System.out.println(driver.getCurrentUrl());
driver.navigate().refresh();
	}
}

