package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RepaymentCalcPage extends BasePage{

	public static final By byLoanAmount = findBy("amount");
	public static final By byTerm = findBy("term");
	public static final By byRepaymentType = findBy("//select[@id='interestOnly']");
	//public static final By byWithA = findBy("//select[@id='productId']");
	public static final By byTotalLoanRepayments = findBy("//span[@data-tid='total-repayment']");
	public static final By byTotalInterestCharged = findBy("//span[@data-tid='total-interest']");
	public static final By byCalculateButton = findBy("submit");
	public static final By byInputInterestRate = findBy("(//a[@id='useProductList'])[1]");
	public static final By byBanner = findBy("//div//span//a[contains(text(), 'Dismiss')]");

	public static void clickOnHomeLoansTab(String data) throws InterruptedException {
		/*if(findObject(byBanner, "Banner").isDisplayed()) {
			driver.findElement(By.xpath("//span//a[contains(text(), 'Dismiss')]")).click();
		}else{
			System.out.println("INFO: Banner is not displayed");
		}*/
		By byHomeLoans = findBy("(//li//a[contains(text(), '"+data+"')])[1]");
		clickElement(byHomeLoans, "Home Loans");
		Thread.sleep(2000);
	}

	public static void clickOnCalculatorsAndTools(String data) throws InterruptedException {
		/*if(findObject(byBanner, "Banner").isDisplayed()) {
		driver.findElement(By.xpath("//span//a[contains(text(), 'Dismiss')]")).click();
		}else{
			System.out.println("INFO: Banner is not displayed");
		}*/
		By byCalculatorsAndTools = findBy("(//li//a[@data-tracker-id='default_0_4'])[1]");
		clickElement(byCalculatorsAndTools, "Calculators And Tools");
	}

	public static void clickOnCalculateNow(String data) {
		/*if(findObject(byBanner, "Banner").isDisplayed()) {
		driver.findElement(By.xpath("//span//a[contains(text(), 'Dismiss')]")).click();
		}else{
			System.out.println("INFO: Banner is not displayed");
		}*/
		By byCalculateNow = findBy("(//p//a[@aria-label='"+data+"'])[2]");
		clickElement(byCalculateNow, "Calculate Now");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void setLoanAmount(String text) throws InterruptedException {
		Thread.sleep(2000);
		if(findObject(byBanner, "Banner").isDisplayed()) {
			driver.findElement(By.xpath("//span//a[contains(text(), 'Dismiss')]")).click();
		}else{
			System.out.println("INFO: Banner is not displayed");
		}
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

	public static String getTotalLoanRepayments() {
		return getText(byTotalLoanRepayments, "Total Loan Repayments");
	}

	public static String getTotalInterestCharged() {
		return getText(byTotalInterestCharged, "Total Interest Charged");
	}

	public static void clickOnInputInterestRate() {
		clickElement(byInputInterestRate, "Input Interest Rate");
	}

	public static void clearInputInterestRate() {
		driver.findElement(By.xpath("//input[@id='customRate']")).clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void setInputInterestRate(String text) {
		driver.findElement(By.xpath("//input[@id='customRate']")).sendKeys(text);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("INFO: Entered input interest rate is : " +text);
	}
}