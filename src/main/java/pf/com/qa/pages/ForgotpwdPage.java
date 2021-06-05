package pf.com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pf.com.qa.base.TestBase;

public class ForgotpwdPage extends TestBase {

@FindBy(xpath="//h1[@class='page-subheading']")
WebElement frpwdtext;

@FindBy(id="email")
WebElement emailbox;





	public ForgotpwdPage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
			}
	
	public String forgotpwdtext() {
		return frpwdtext.getText();
	}
	
	public boolean emailboxPresent() {
		return emailbox.isDisplayed();
		}
	
	
	

}
