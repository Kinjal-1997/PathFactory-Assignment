package pf.com.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pf.com.qa.base.TestBase;
import pf.com.qa.pages.HomePage;
import pf.com.qa.pages.LoginPage;
import pf.com.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	String userCred;
	String sheetName = "Sheet1";
	String alert = "Authentication failed.";

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		lp = new LoginPage();
	}
	public void logintitletest() {
		Assert.assertEquals(lp.verifyLoginpagetitle(), "Login - My Store");
	}

	@Test
	public void reglinktexttest() {
		Assert.assertEquals(lp.reglinkText(), "ALREADY REGISTERED?");
	}

	@Test
	public void reglinkdispalyedtest() {
		Assert.assertEquals(lp.regLinkavailable(), true);
	}

	@Test
	public void emailboxverifytest() {
		Assert.assertEquals(lp.emailboxcheck(), true);
	}

	@Test
	public void pwdboxverifytest() {
		Assert.assertEquals(lp.pwdboxcheck(), true);
	}

	@DataProvider
	public Object[][] getPfTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(dataProvider = "getPfTestData")
	public void loginTest(String username, String password) throws IOException {
		hp = lp.login(username, password);
	}

	@Test(dataProvider = "getPfTestData")
	public void loginTestwithEnterbtn(String username, String password) throws IOException {
		hp = lp.login(username, password);
	}

	@Test
	public void alertverify() {
		Assert.assertEquals(lp.alermsg(), alert);

	}

	@Test
	public void forgotpwdlinkTest() {
		Assert.assertEquals(lp.verifyforgotpwdlink(), true);
	}

	@Test
	public void signinbtnenabletest() {
		Assert.assertEquals(lp.signinbtnenabled(), true);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
