package CucumberTest.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
	features = {"src/test/java/CucumberTest/featureFiles"},
	glue = {"CucumberTest.stepFiles"},
	monochrome = true,
	plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},
	tags = "@Unit"
	
)

public class Mainrunner  {

}
