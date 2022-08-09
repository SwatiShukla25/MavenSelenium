package StepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/CucumberProject/",
glue= {"StepDefinationUserLogin","StepDefinationBookAFlight"}
)



public class TestRunner {

}
