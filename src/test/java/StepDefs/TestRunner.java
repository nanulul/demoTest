package StepDefs;

import io.cucumber.core.gherkin.Feature;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/Features", glue = {"StepDefs","hooks"}, plugin = {"pretty","html:target/HTMLReports"})
public class TestRunner {
}
