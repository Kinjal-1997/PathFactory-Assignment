package pf.com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pf.com.qa.base.TestBase;
import pf.com.qa.pages.ForgotpwdPage;
import pf.com.qa.pages.LoginPage;

public class ForgotpwdPageTest extends TestBase {

	public ForgotpwdPageTest() throws IOException {
		super();
	}

	ForgotpwdPage fp;
	LoginPage lp;

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		fp = new ForgotpwdPage();
		lp = new LoginPage();
	}

	@Test
	public void forgotpwstextverify() {
		String text1 = fp.forgotpwdtext();
		Assert.assertEquals(text1, "Forgot your password?");
	}

	@Test
	public void emailtextverify() {
		String text2 = fp.emaitext();
		Assert.assertEquals(text2, "Please enter the email address you used to registe");
	}

	@Test
	public void emailboxverify() {
		Assert.assertEquals(fp.emailboxPresent(), true);
	}

	@Test
	public void retrievebtnverify() {
		Assert.assertEquals(fp.retrivebtnenabled(), true);
	}

	@Test
	public void backbtnverify() throws IOException {
		lp = fp.backbtnenabled();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
