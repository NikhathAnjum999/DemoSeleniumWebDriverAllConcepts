package demoTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/*
 * 	//if findElement's locator not found then it returns element not found exception, if findElemts's(list) locator not found it returns 0
	//h2[contains(text(),'Tabs')]
	//h2[starts-with(text(),'Tabs')]
	//h2[text()='Tabs']
	//h2[contains(@class,'title')]
	//h2[starts-with(@class,'ti')]
	//h2[starts-with(text(),'Ta')]
	//h2[contains(text(),'Tabs')]
	// for immedaite child selection '/' reqiured
	// for any decendant child selection '//' reqiured
	///
	///alerts or popUps
	//driver.switchTo().alert().accept()
	///driver.switchTo().alert().dismiss()
	///driver.switchTo().alert().getText()
	///driver.switchTo().alert().sendKeys()
	///optimized- store "driver.switchTo().alert()" and perform accept, dismiss, getText..etc
	///it cant return input data it gives only alert text
	///Three types of swictcing-Windows,frames,alerts
	///
	///Day-33
--------
Dynamic table with pagination
--------

String s="Showing 1 to 10 of 19081 (13232 Pages)"

 s.substring(s.indexOf("(")+1,s.indexOf("Pages")-1)  --> 1909
 
 build()-creates an action
 perform()-complete an actions
 
 Mouse hover-moveToElement(element)
 right click-contextClick(elemtn)
 double click-doubleClick(element)
 drag and drop
 Actions - predefined class defined in a selenium
 getText() or getAttribute("")=>
 <input id='xyz' name='wlcm'>WELCOME</input>
 getText()- returns WELCOME
 getAttribute("id")- returns xyz
 getAttribute("name")- returns wlcm
 Actions-class uses to perfome actions
 Action- used to store created actions
 actionCLassVaribale.keyUp & .keyDown -for spcl keyword(ctrl,shift..etc) otherwise sendKeys("any Key board Key")
 driver.switchT0().newWindow(windowType.Tab)- opens new Tab
 * */
public class Tuesday {
	public WebDriver driver;
	@BeforeMethod
	public void setUpMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("disable-infobars");
//		options.addArguments("--headless=new");//no UI
//		options.setAcceptInsecureCerts(true);//accepts SSL certificates
//		options.setExperimentalOption("excludeSwicthes", new String[] {"enable-automation"});//remove chrome is controlled by the automation tester
//		options.addArguments("--incognito");
//		
		 driver=new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

//	@Test
	public void TuesadayTest_One() {
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//using CSS selector ID
	driver.findElement(By.cssSelector("#name")).sendKeys("Sadaf");
	//using CSS Selector .class
	System.out.println(driver.findElement(By.cssSelector(".titlewrapper")).getText());
	//using Css Selector tag.class
	System.out.println(driver.findElement(By.cssSelector("h1.title")).getText());
	//using CSS Selector tag.ID
	System.out.println(driver.findElement(By.cssSelector("div#header-inner")).getText());
	//using CSS Selector tag[attribute=value]
	driver.findElement(By.cssSelector("input[placeholder='Enter EMail']")).sendKeys("Test@gmail.com");
	//using CSS selector [attribute=value]
	driver.findElement(By.cssSelector("[placeholder='Enter Phone']")).sendKeys("91006509382");
	//XPATH relative (starts with //) & absolute(starts with //)
	//relative xpath
	//relative xpath - contains attribute, does not travel through each node directly jump into the element by using attribute
	System.out.println(driver.findElement(By.xpath("//textarea[@id='textarea']")));
	//absolute xpath - does not contain attribute, travel through each node 
	driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
	System.out.println(driver.findElement(By.xpath("//input[@placeholder=\"Enter Name\"][@type=\"text\"]")).getAttribute("value")+"\t :Name");
	List<WebElement> listOfPlaceHolderBygetAttribute=driver.findElements(By.xpath("//input[@placeholder=\"Enter Name\" or @type=\"text\"]"));
	for(WebElement placeHolders:listOfPlaceHolderBygetAttribute) {
		System.out.println(placeHolders.getAttribute("value")+"\t"+"||");
	}
	// <div>Hello</div> -inner text , <div class="Hello"></div> inner text, <a>Click me</a>- inner text and link text all link text are inner text but not all the inner text is not a link text
	
	System.out.println(driver.findElement(By.xpath("//h2[text()='Tabs']")).getText());
	driver.findElement(By.xpath("//h2[text()='Upload Files']")).isDisplayed();
	driver.findElement(By.xpath("//input[@id='sunday']")).isSelected();
	///input[contains(@id,'name') or contains( @type,'text')]
	///input[contains(@id,'name') and contains( @type,'text')]
	System.out.println(driver.findElement(By.xpath("//input[contains(@id,'name') and contains( @type,'text')]")).getAttribute("value"));
	//label[text()='Monday'][contains(@for,'monday')]
	System.out.println(driver.findElement(By.xpath("//label[text()='Monday'][contains(@for,'monday')]")).getAttribute("value"));
	//methods
	System.out.println(driver.getTitle()+"\t"+driver.getCurrentUrl()+"\t"+driver.getPageSource()+"\t"+driver.getWindowHandle());
	driver.findElement(By.xpath("//button[text()=\"New Tab\"]")).click();
	driver.findElement(By.xpath("//button[text()=\"Popup Windows\"]")).click();
	Set<String> getIdsOFBrwoser=driver.getWindowHandles();
	List<String> ids=new ArrayList<String>(getIdsOFBrwoser);
	/*
	 * The main reason is that Set doesn't provide a way to access elements by their index. 
	 * If you want to switch to a specific window (e.g., the second window), you can't do it 
	 * directly with a Set. With a List, you can access the second window handle using ids.get(1).
	 * 
	 * if you want to peform testing on specific page then you can captured the titles by itearratint the windowids and compare them and check with current urls
	 * */
//	Approach1
	String firstPage=ids.get(0);
	String scndPage=ids.get(1);
	System.out.println(firstPage+" "+scndPage);
	for(String id:ids) {
		String title=driver.switchTo().window(id).getTitle();
//		driver.switchTo().window(id).findElement(By.xpath(""))---example for finding element ,once you entred intothat particular page no need to swicth btw the pages directly tetsing can be pefomrd
		System.out.println(title+"I am title");
		 driver.switchTo().window(id);
	String titleOfDiffBrowsers=driver.getTitle();
	System.out.println(titleOfDiffBrowsers+"\t from new Browser");
	driver.switchTo().defaultContent();
	}
	
	}
//	@Test
	public void TuesadayTest_Two() {
		System.out.println(driver.findElement(By.linkText("Blog")).isDisplayed()+"\n"+driver.findElement(By.partialLinkText("Online")).getText());
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement ele1=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
		ele1.sendKeys("NK");
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.accept();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//implicit wait applies to all
		//fluent wait
		 Wait<WebDriver> fWait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(30))
	                .pollingEvery(Duration.ofSeconds(5))
	                .ignoring(NoSuchElementException.class);
	        WebElement element = fWait.until(driver -> driver.findElement(By.xpath("//h2[text()='Tabs']")));
	        System.out.println(element.getText());
	        /*
	         * NOSuchEleemntException- element not present on the page
	         * ElemntNotFound- incorrect syntax
	         * Synchrnization can be done, thread or implicit wait or explicit/fluent wait
	         * thread- need to write multiple times whereever waititng is reqiured, wait for maximum timeout
	         * implicit- one time enough , wont wait for max timeout if elemnt is avaible
	         * explicit - define multiple times, wait for max timeout
	         * */
	      
	}
//	@Test
	public void TuesdayTest_Three() throws MalformedURLException {
		  URL  url=new URL("https://www.google.com/");
	        driver.navigate().to(url);//accepts URL in object(URL) format also in string format, get only string format.
	        System.out.println(driver.getCurrentUrl());
	        URL fileUrl = new URL("file:///C:/path/to/file.html");
	        driver.navigate().to(fileUrl);
	        driver.navigate().back();
	        System.out.println(driver.getCurrentUrl());
	        driver.navigate().forward();
	        System.out.println(driver.getCurrentUrl());
	        driver.navigate().refresh();
	        /*Navigations*/
	        WebElement button=driver.findElement(By.xpath("//button[@id='btn1']"));
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        js.executeScript("argument[0].click()",button);
	        /*JS code executing in sleeneium*/
	}
	
//	@Test
	public void FramesExample() {
		//https://ui.vision/demo/webtest/frames/
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://ui.vision/demo/webtest/frames/");
			driver.manage().window().maximize();
			  //Frame 1
	        WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
	        driver.switchTo().frame(frame1); // pass frame1, or with switchTo().frame(1)
	        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");
	        driver.switchTo().defaultContent();// go back to page
	        //Frame2
	        WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
	        driver.switchTo().frame(frame2);
	        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("selenium");
	        driver.switchTo().defaultContent();// go back to page
	        WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
	        driver.switchTo().frame(frame3);
	        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");
	      //inner iframe - part of frame 3
	        driver.switchTo().frame(0); // switching to frame using index
	        driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();
	        
	}
	//@Test
	public void DynamicPaginationTable() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikha\\OneDrive\\Documents\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
			driver.get("https://practice.expandtesting.com/dynamic-pagination-table");
			driver.manage().window().maximize();
			WebElement table=driver.findElement(By.xpath("//table[@id='example']"));
			List<WebElement> tableRow=table.findElements(By.xpath("//tr"));
			for(WebElement row:tableRow) {
				List<WebElement> tableData=row.findElements(By.xpath("//td"));
				
				for(WebElement data:tableData) {
					System.out.print(data.getText()+"|");
//					System.out.println();
					
				}
				
				
				break;
			}
			System.out.println("\n");
			
	}
//	@Test
	public void actionsExample() {
		WebElement drpButton=driver.findElement(By.xpath("//button[@class='dropbtn']"));
		
		List<WebElement> links=driver.findElements(By.xpath("//div[@class='dropdown-content']//a"));
		Actions  action=new Actions(driver);
		action.moveToElement(drpButton).moveToElement(links.getFirst()).moveToElement(links.getLast()).build().perform();
		//JS executor
		WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].setAttribute('value','Nikhath')", name);
	}
	@Test
	public void capturedScreenShort() {
		TakesScreenshot ts=((TakesScreenshot)driver);
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);//screenshots\\fullPage.png
		File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\appPage.png");
		sourceFile.renameTo(targetFile);
		System.out.println(targetFile);
		WebElement drpButton=driver.findElement(By.xpath("//button[@class='dropbtn']"));
		File buttonSs=drpButton.getScreenshotAs(OutputType.FILE);
		File targetButton=new File(System.getProperty("user.dir")+"\\screenshots\\btn.png");
		buttonSs.renameTo(targetButton);
		//SS of specific section
		WebElement sideElement=driver.findElement(By.xpath("//div[@class='column-right-inner']"));
		File sideSs=sideElement.getScreenshotAs(OutputType.FILE);
		File targetSide=new File(System.getProperty("user.dir")+"\\screenshots\\sideBar.png");
		sideSs.renameTo(targetSide);
		////div[@class='svg-container']//*[name()='svg']
		///
		WebElement imsgeSS=driver.findElement(By.xpath("//img[@class='wikipedia-icon']"));
		File sourceImage=imsgeSS.getScreenshotAs(OutputType.FILE);
		File targetImage=new File(System.getProperty("user.dir")+"\\screenshots\\imageSS.png");
		sourceImage.renameTo(targetImage);
		WebElement svgSS=driver.findElement(By.xpath("//div[@class='svg-container']//*[name()='svg']"));
		File sourcesvgSS=svgSS.getScreenshotAs(OutputType.FILE);
		File targetsvgSS=new File(System.getProperty("user.dir")+"\\screenshots\\svgSS.png");
		sourcesvgSS.renameTo(targetsvgSS);
		
		driver.quit();
	}
//	@Test
	public void handleBrokenLinks() throws IOException {
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		int brokenLinkCount=0;
		int validLinks=0;
		for(WebElement link:links) {
			String linkValue=link.getAttribute("href");
			if(linkValue==null || linkValue.isEmpty()) {
				brokenLinkCount++;
				continue;
//				break;
			}
			URL urlLinks=new URL(linkValue);
			HttpURLConnection con=(HttpURLConnection) urlLinks.openConnection();  
			con.connect();
			if(con.getResponseCode()>=400) {
				System.out.println("Broken Link");
				brokenLinkCount++;
			}else {
				System.out.println("Not Broken Link");
				validLinks++;
			}
		}
		System.out.println("Broken links"+brokenLinkCount+"\t"+"Valid links"+validLinks);
		
	}
}
