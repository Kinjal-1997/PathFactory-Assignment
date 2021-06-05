package pf.com.qa.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pf.com.qa.base.TestBase;
import pf.com.qa.pages.ForgotpwdPage;
import pf.com.qa.pages.HomePage;
import pf.com.qa.pages.LoginPage;
import pf.com.qa.util.ExcelUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	ForgotpwdPage fp;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		lp = new LoginPage();
		fp= new ForgotpwdPage();
	}

	@Test
	public void loginTitleTest() {
		Assert.assertEquals(lp.verifyLoginpagetitle(), "Login - My Store");
	}

	@Test
	public void reglinkTextTest() {
		Assert.assertEquals(lp.reglinkText(), "ALREADY REGISTERED?");
	}

	@Test
	public void reglinkDispalyedTest() {
		Assert.assertEquals(lp.regLinkavailable(), true);
	}

	@Test
	public void emailboxverifytest() {
		Assert.assertEquals(lp.emailboxcheck(), true);
	}

	@Test
	public void pwdboxVerifyTest() {
		Assert.assertEquals(lp.pwdboxcheck(), true);
	}

	@Test
	public void loginSuccessfulTest() throws IOException {
		hp = lp.login(prop.getProperty("usernamecorrect"), prop.getProperty("passwordcorrect"));
		Assert.assertEquals(hp.verifyCorrectUserName(), true);
	}

	@Test

	public void loginWithEnterbtnTest() throws IOException {
		hp = lp.loginwithEnter(prop.getProperty("usernamecorrect"), prop.getProperty("passwordcorrect"));
		Assert.assertEquals(hp.verifyCorrectUserName(), true);
	}

	@Test
	public void loginWithIncorrectData() {
		lp.loginwithIncorrectData(prop.getProperty("wrongemail1"), prop.getProperty("wrongpwd1"));
		Assert.assertEquals(lp.errorMsgVerify(), "Authentication failed." );
	}

	@Test
	public void wronEmailcorrectPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("wrongEmail2"), prop.getProperty("correctpwd1"));
		Assert.assertEquals(lp.errorMsgVerify(), "Authentication failed.");
	}

	@Test
	public void correctEmailwronPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("correctemail1"), prop.getProperty("wrongpwd2"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid password.");
	}

	@Test
	public void emptyEmailcorrectPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("emptyemail"), prop.getProperty("correctpwd2"));
		Assert.assertEquals(lp.errorMsgVerify(),"Invalid email address.");
	}

	@Test
	public void emptyEmailwronPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("emptyemail2"), prop.getProperty("wrongpwd2"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid email address.");
	}

	@Test
	public void correctEmailemptyPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("correctemail2"), prop.getProperty("emptypwd2"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid password.");
	}

	@Test
	public void wronEmailemtyPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("wrongemail2"), prop.getProperty("emptypwd2"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid password.");
	}

	@Test
	public void invalidEmailcorrectPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("invalidemail1"), prop.getProperty("corectpwd2"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid email address.");
	}

	@Test
	public void invalidEmailwronPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("invalidemail2"), prop.getProperty("wronpwd3"));
		Assert.assertEquals(lp.errorMsgVerify(), "Invalid email address.");
	}
	
	@Test
	public void emptyEmailemptyPwdTest() {
		lp.loginwithIncorrectData(prop.getProperty("emptyemail3"), prop.getProperty("emptypwd3"));
		Assert.assertEquals(lp.errorMsgVerify(), "An email address required.");
	}
	
	@Test
	public void verifyForgotPwdTest() {
		lp.verifyforgotpwdlink();
	}

	 @Test
	public void forgotpwdLinkTest() throws IOException {
		fp= lp.forgotpassword();
		Assert.assertEquals(fp.forgotpwdtext(), "FORGOT YOUR PASSWORD?");
	}

	 @Test
	public void signinbtnEnableTest() {
		Assert.assertEquals(lp.signinbtnenabled(), true);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
