package Test_Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = {"src/main/java/Features"},
                glue = {"StepDefinitions"},
                plugin = {"json:target/cucumber.json"}
        )

public class TestRunner {

}