package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				tags = "@Test1 or @Test2 or @Test3 or @Test4",
				features = {"src/test/resources/features/"},
				glue = {"stepDefination"},
				plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome = true,
				strict = true)

public class SmokeRunner {

	
}
