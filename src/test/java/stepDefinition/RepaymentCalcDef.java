package stepDefinition;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasePage;
import pages.RepaymentCalcPage;

public class RepaymentCalcDef extends BasePage{

	@Given("User is on landing page of the CBA website")
	public void user_is_on_landingPage_of_the_CBA_website() {
		openUrl();
	}

	@When("User clicks on {string} tab")
	public void user_clicks_on_homeLoans_tab(String string) throws InterruptedException {
		RepaymentCalcPage.clickOnHomeLoansTab(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User clicks on {string} link")
	public void user_clicks_on_calculatorsAndTools_link(String string) throws InterruptedException {
		RepaymentCalcPage.clickOnCalculatorsAndTools(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User clicks on Home loan repayments calculator {string} link")
	public void user_clicks_on_home_loan_repayments_calculator_calculateNow_link(String string) {
		RepaymentCalcPage.clickOnCalculateNow(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User enters {string} as Loan Amount")
	public void user_enters_as_loan_amount(String string) throws InterruptedException {
		RepaymentCalcPage.setLoanAmount(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User enters {string} as term")
	public void user_enters_as_term(String string) {
		RepaymentCalcPage.setTerm(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User selects {string} as repayment type")
	public void user_selects_as_repayment_type(String string) {
		RepaymentCalcPage.selectRepaymentType(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User selects {string} in owner occupied")
	public void user_selects_in_owner_occupied(String string) {
		RepaymentCalcPage.selectWithaStandard(string);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("User clicks on calculate button")
	public void user_clicks_on_calculate_button() {
		RepaymentCalcPage.clickOnCalculateButton();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("User enters {string} and {string} and {string} and {string} for Home Loan repayment")
	public void user_enters_loanAmount_and_term_and_repaymentType_and_withStandard1_for_home_loan_repayment(String string, String string2, String string3, String string4) throws InterruptedException {
		RepaymentCalcPage.setLoanAmount(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		RepaymentCalcPage.setTerm(string2);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		RepaymentCalcPage.selectRepaymentType(string3);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		RepaymentCalcPage.selectWithaStandard1(string4);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User clicks on Input interest rate")
	public void user_clicks_on_input_interest_rate() {
		RepaymentCalcPage.clickOnInputInterestRate();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		RepaymentCalcPage.clearInputInterestRate();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User enters {string} and {string} and {string} for Home Loan repayment")
	public void user_enters_loanAmount_and_term_and_repayment_for_home_loan_repayment(String string, String string2, String string3) throws InterruptedException {
		RepaymentCalcPage.setLoanAmount(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		RepaymentCalcPage.setTerm(string2);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		RepaymentCalcPage.selectRepaymentType(string3);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User enters {string} an interest rate in text field")
	public void user_enters_an_interest_rate_in_text_field(String string) {
		RepaymentCalcPage.setInputInterestRate(string);
	}

	@Then("User validate {string} and {string} details")
	public void user_validate_totalLoanRePayments_and_totalInterestCharged_details(String string1, String string2) {
		String totLoanRePay = RepaymentCalcPage.getTotalLoanRepayments();
		Assert.assertTrue(totLoanRePay.equals(string1));
		String totInterestCharged = RepaymentCalcPage.getTotalInterestCharged();
		Assert.assertTrue(totInterestCharged.equals(string2));
	}
}