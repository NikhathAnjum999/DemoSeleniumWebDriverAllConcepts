package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageFactory {
WebDriver driver;
public loginPageFactory(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@id='email']") WebElement emailValue;
@FindBy(id="pass") WebElement password;
@FindBy(name="login") WebElement loginButton;
@FindBy(tagName="a") List<WebElement> links;

public void sendEmail(String emailData) {
	emailValue.sendKeys(emailData);
}

public void sendPassword(String passwordData) {
	password.sendKeys(passwordData);
}

public void loginButton() {
	loginButton.click();
}
public void printLinkTexts() {
    for (WebElement link : links) {
        System.out.println(link.getText());
    }
}

}
