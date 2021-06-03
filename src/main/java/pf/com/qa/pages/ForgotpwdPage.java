package pf.com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pf.com.qa.base.TestBase;

public class ForgotpwdPage extends TestBase {

@FindBy(xpath="//h1[@class='page-subheading']")
WebElement frpwdtext;

@FindBy(xpath="//p[contains(text(),'Please enter the email address you used to registe')]")
WebElement emailtext;

@FindBy(id="email")
WebElement emailbox;

@FindBy(xpath="//span[contains(text(),'Retrieve Password')]")
WebElement retrievebtn;

@FindBy(xpath="//span[contains(text(),'Back to Login')]")
WebElement backbtn;



	public ForgotpwdPage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
			}
	public String forgotpwdtext() {
		return frpwdtext.getText();
	}
	public String emaitext() {
		return emailtext.getText();
		}
	public boolean emailboxPresent() {
		return emailbox.isDisplayed();
		}
	public boolean retrivebtnenabled() {
		return retrievebtn.isEnabled();
		}
	public LoginPage backbtnenabled() throws IOException {
		 backbtn.isEnabled();
		 return new LoginPage();
	}

}
