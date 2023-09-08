import org.testng.annotations.DataProvider;
import org.matrix.infra.TestProperties;
import org.matrix.pages.DashboardPage;
import org.matrix.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The Class LoginPageTest.
 *
 * @author AbedZoabi
 */
@Test(testName = "Login Test", description = "enter user name and password then click login")
public class LoginPageTest extends BaseTest {

	/**
	 * Positive test getting country for "Island Trading" company
	 */
	@Test(testName = "LOGIN TEST")
	public void loginTestAndVerifyTable() {


		driver.get(TestProperties.getProperty("url"));


		LoginPage login = new LoginPage();


		login.enterUsername("AbedZoabi");
		login.enterPassword("123456789");

		login.clickLogin();


		DashboardPage dashboard = new DashboardPage();
		Assert.assertTrue(dashboard.checkIfTableDisplayed(), "Login was not succeed");
//
		int CompleteCount = dashboard.getCountOfStatusComplete();
//
		Assert.assertEquals(CompleteCount, 2);


	}

	@DataProvider(name = "additionData")
	public Object[][] additionData() {
		return new Object[][] {
				{ "AbedZoabi","123456789"}// Will pass
		};
	}
}
