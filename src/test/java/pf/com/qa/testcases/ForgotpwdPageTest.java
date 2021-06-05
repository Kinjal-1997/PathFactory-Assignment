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
		fp= lp.forgotpassword();
	}

	@Test
	public void forgotpwstextverify() {
		String text1 = fp.forgotpwdtext();
		Assert.assertEquals(text1, "FORGOT YOUR PASSWORD?");
	}

	@Test
	public void emailboxverify() {
		Assert.assertEquals(fp.emailboxPresent(), true);
	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
