package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class instaLoginPOM extends BasePage{
	WebDriver driver;
public instaLoginPOM(WebDriver driver){
	super(driver);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

@FindBy(xpath="//input[@name='username']")  WebElement instaUserName;
@FindBy(xpath="//input[@name='password']") WebElement instaPassword;
@FindBy(xpath="//div[text()=\"Log in\"]") WebElement loginInsta;

public void loginInstagram(String emailInsta,String passwordInsta) {
	instaUserName.sendKeys(emailInsta);
	instaPassword.sendKeys(passwordInsta);
	loginInsta.click();
}
}
