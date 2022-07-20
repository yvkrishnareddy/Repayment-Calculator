package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	public static WebDriver driver;

	public static void openUrl() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.commbank.com.au/");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		System.out.println("INFO: Url is - " +driver.getCurrentUrl());
		System.out.println("INFO: Title of the page is : " +driver.getTitle());
	}

	public static By findBy(String sLocator) {
		By byElement = null;
		if(sLocator.contains("/")) {
			byElement = By.xpath(sLocator);
		}else {
			byElement = By.id(sLocator);
		}
		return byElement;
	}

	public static WebElement findObject(By ele, String selector) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement wEle =  wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		return wEle;
	}

	public static WebElement findObject1(By ele, String selector) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement wEle =  wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		return wEle;
	}

	public static void clickElement(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		try {
			Actions act = new Actions(driver);
			act.click(wEle).build().perform();
			System.out.println("INFO: Element "+selector+ " is clicked");
		} catch (Exception e) {
			System.out.println("ERROR: Element is "+selector+" not clickable");
		}
	}

	public static void setText(By ele, String selector, String text) {
		WebElement wEle =  findObject(ele, selector);
		try {
			Actions act = new Actions(driver);
			act.sendKeys(wEle, text).build().perform();
			System.out.println("INFO: Entering text in "+selector+ " is :" +text);
		} catch (Exception e) {
			System.out.println("ERROR: Entering text in "+selector+ " is failed");
		}
	}

	public static String getText(By ele, String selector) {
		WebElement wEle =  findObject(ele, selector);
		String text = wEle.getText();
		System.out.println("INFO: Getting text from "+selector+ " is : " +text);
		return text;
	}

	public static String getAttribute(By ele, String selector) {
		WebElement wEle =  findObject(ele, selector);
		String text = wEle.getAttribute("value");
		System.out.println("INFO: Getting text from "+selector+ " is : " +text);
		return text;
	}

	public static void selectFromDropDown(By ele, String selector, String text) {
		WebElement wEle = findObject(ele, selector);
		try {
			Select sel = new Select(wEle);
			sel.selectByVisibleText(text);
			System.out.println("INFO: Element from " +selector+ "selected is : "+text);
		} catch (Exception e) {
			System.out.println("ERROR: Element from " +selector+ "is not selected");
		}
	}

	public static void selectFromDropDownByValue(By ele, String selector, String text) {
		WebElement wEle = findObject(ele, selector);
		try {
			Select sel = new Select(wEle);
			sel.selectByValue(text);
			WebElement selectVal = sel.getFirstSelectedOption();
			System.out.println("INFO: Element from " +selector+ "selected is : "+selectVal.getText());
		} catch (Exception e) {
			System.out.println("ERROR: Element from " +selector+ "is not selected");
		}
	}
}