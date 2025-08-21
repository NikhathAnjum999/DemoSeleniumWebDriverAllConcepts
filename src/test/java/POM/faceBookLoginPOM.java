package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class faceBookLoginPOM extends BasePage {
	WebDriver driver;
	public faceBookLoginPOM(WebDriver driver){
		super(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
@FindBy(xpath="//input[@id='email']") WebElement emailAddress;
@FindBy(id="pass") WebElement passWord;
@FindBy(name="login") WebElement loginBtn;
public void loginToFaceBook(String emailId,String password) {
	emailAddress.sendKeys(emailId);
	passWord.sendKeys(password);
	loginBtn.click();
}
}
