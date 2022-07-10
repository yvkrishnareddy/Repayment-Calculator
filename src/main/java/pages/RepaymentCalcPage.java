package pages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RepaymentCalcPage extends BasePage{

	public static final By byLoanAmount = findBy("amount");
	public static final By byTerm = findBy("term");
	public static final By byRepaymentType = findBy("//select[@id='interestOnly']");
	public static final By byWithA = findBy("//select[@id='productId']");
	public static final By byTotalLoanRepayments = findBy("//span[@data-tid='total-repayment']");
	public static final By byTotalInterestCharged = findBy("//span[@data-tid='total-interest']");
	public static final By byCalculateButton = findBy("submit");
	public static final By byInputInterestRate = findBy("(//a[@id='useProductList'])[1]");
	
	public static void clickOnHomeLoansTab(String data) {
		By byHomeLoans = findBy("(//li//a[contains(text(), '"+data+"')])[1]");
		clickElement(byHomeLoans, "Home Loans");
	}

	public static void clickOnCalculatorsAndTools(String data) {
		By byCalculatorsAndTools = findBy("//span[contains(text(), '"+data+"')]");
		clickElement(byCalculatorsAndTools, "Calculators And Tools");
	}

	public static void clickOnCalculateNow(String data) {
		By byCalculateNow = findBy("(//p//a[@aria-label='"+data+"'])[2]");
		clickElement(byCalculateNow, "Calculate Now");
	}

	public static void setLoanAmount(String text) throws InterruptedException {
		driver.findElement(By.id("amount")).clear();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		setText(byLoanAmount, "Loan Amount", text);
	}

	public static void setTerm(String data) {
		driver.findElement(By.id("term")).clear();
		setText(byTerm, "Term", data);
	}

	public static void selectRepaymentType(String data) {
		selectFromDropDown(byRepaymentType, "Repayment Type", data);
	}

	public static void selectWithaStandard(String data) {
		By byEle = findBy("//select[@id='productId']/optgroup[1]");	
		WebElement wEle = findObject(byEle, "With a");
		try {
			Select sel = new Select(wEle);
			sel.selectByValue(data);
			System.out.println("INFO: Element selected is : "+wEle.getText());
		} catch (Exception e) {
			System.out.println("ERROR: Element is not selected");
		}	
	}
	
	public static void selectWithaStandard1(String data) {
		By byEle = findBy("//select[@id='productId']");
		selectFromDropDownByValue(byEle, "With a ", data);
		
	}
	
	public static void clickOnCalculateButton() {
		clickElement(byCalculateButton, "Calculate  Button");
	}

	public static void getTotalLoanRepayments() {
		getText(byTotalLoanRepayments, "Total Loan Repayments");
	}

	public static void getTotalInterestCharged() {
		getText(byTotalInterestCharged, "Total Interest Charged");
	}
	
	public static void clickOnInputInterestRate() {
		clickElement(byInputInterestRate, "Input Interest Rate");
	}
	
	public static void clearInputInterestRate() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='customRate']")).clear();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void setInputInterestRate(String text) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='customRate']")).sendKeys(text);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("INFO: Entered input interest rate is : " +text);
	}
}
