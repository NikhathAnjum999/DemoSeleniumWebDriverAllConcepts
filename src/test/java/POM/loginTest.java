package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginTest {
	WebDriver driver;
	By userEmail=By.id("email");
	By userPassword=By.id("pass");
	By button=By.name("login");
	public loginTest(WebDriver driver) {
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void userEmail(String email) {
	driver.findElement(userEmail).sendKeys(email);
	}
	public void userPassword(String password) {
		driver.findElement(userPassword).sendKeys(password);
	}
	public void loginButton() {
		driver.findElement(button).click();
		
	}
public void loginToApp(String mail,String password) {
	userEmail(mail);
	userPassword(password);
	loginButton();
}
}
