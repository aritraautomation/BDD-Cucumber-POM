package parallelexecution;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	private String title;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String,String>> credList = credTable.asMaps();
		
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		accountPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {		
		title = accountPage.getAccountsPageTitle();
		System.out.println("Login Page Title : " + title);	
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		
		List<String> expectedSectionList = sectionTable.asList();
		System.out.println("Expected Account Section List : " + expectedSectionList);
		
		List<String> actualSectionList = accountPage.getAccountSectionList();
		System.out.println("Actual Account Section List : " + actualSectionList);
		
		Assert.assertTrue(expectedSectionList.containsAll(actualSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		int actualSectionCount = accountPage.getAccountSectionCount();
		
		Assert.assertTrue(expectedSectionCount==actualSectionCount);
	   
	}

}
