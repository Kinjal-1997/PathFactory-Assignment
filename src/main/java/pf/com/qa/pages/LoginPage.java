package pf.com.qa.pages;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pf.com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "passwd")
	WebElement password;

	@FindBy(name = "SubmitLogin")
	WebElement signinbtn;

	@FindBy(xpath = "//p[@class = 'submit']")
	WebElement signinbtnbox;

	@FindBy(linkText = "Forgot your password?")
	WebElement forgotpwd;

	@FindBy(xpath = "//h3[contains(text(),'Already registered?')]")
	WebElement reglink;

	@FindBy(id = "email")
	WebElement emailbox;

	@FindBy(xpath = "//label[contains(text(),'Password')]")
	WebElement pwdbox;

	@FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
	WebElement errormsg;

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String verifyLoginpagetitle() {
		return driver.getTitle();
	}

	public boolean regLinkavailable() {
		return reglink.isDisplayed();
	}

	public String reglinkText() {
		return reglink.getText();
	}

	public boolean emailboxcheck() {
		return emailbox.isDisplayed();
	}

	public boolean pwdboxcheck() {
		return pwdbox.isDisplayed();
	}

	public HomePage login(String us, String pwd) throws IOException {
		username.sendKeys(us);
		password.sendKeys(pwd);
		signinbtn.click();
		return new HomePage();
	}

	public HomePage loginwithEnter(String us, String pwd) throws IOException {
		username.sendKeys(us);
		password.sendKeys(pwd);
		password.sendKeys(Keys.ENTER);
		return new HomePage();
	}

	public void loginwithIncorrectData(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		signinbtn.click();
	}

	public void wrongEmailcorrectPwd(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		signinbtn.click();
	}

	public void correctEmailwrongPwd(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		signinbtn.click();
	}

	public void emptyEmailcorrectPwd(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		signinbtn.click();
	}

	public void emptyEmailwronPwd(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		signinbtn.click();
	}

	public void correctEmaailemptyPwd(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		signinbtn.click();
	}

	public void wrongEmailemptyPwd(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		signinbtn.click();
	}

	public void invalidEmailcorrectPwd(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		signinbtn.click();
	}

	public void InvalidemailWrongPwd(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		signinbtn.click();
	}

	public String errorMsgVerify() {
		return errormsg.getText();

	}

	public boolean verifyforgotpwdlink() {
		return forgotpwd.isDisplayed();
	}

	public ForgotpwdPage forgotpassword() throws IOException {
		forgotpwd.click();
		return new ForgotpwdPage();
	}

	public boolean signinbtnenabled() {
		return signinbtnbox.isEnabled();
	}
	
	
}
