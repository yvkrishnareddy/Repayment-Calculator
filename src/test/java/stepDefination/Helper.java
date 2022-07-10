package stepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.BasePage;

public class Helper extends BasePage{
	
	@Before
	public void InitialSetUp(Scenario scenario) throws InterruptedException {
		System.out.println("************* STARTING NEW TEST **************");
		System.out.println("INFO: Initial setup for new Test");
		System.out.println("INFO: Scenario :" +scenario.getName());
		System.out.println("INFO: Initial setup Done");	
	}
	
	@After
	public void closeSetup() {
		System.out.println("INFO: Inside CloseSetup");
		driver.quit();
		System.out.println("INFO: CloseSetup Done");
		System.out.println("************* END TEST ************");
 }
}


