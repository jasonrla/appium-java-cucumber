package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = {"classpath:features"},
        glue= {"steps"},
        plugin= {"pretty","html:target/cucumber-html-report.html"})
public class TestRunner extends TestBase {
}
