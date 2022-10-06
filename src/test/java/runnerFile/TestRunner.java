package runnerFile;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
				features ="D:\\IndianArmy\\src\\test\\resources\\featureFile",
				glue = "stepDefinition",
				monochrome = true,
				publish = true,
				plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				)
public class TestRunner extends AbstractTestNGCucumberTests{

}
