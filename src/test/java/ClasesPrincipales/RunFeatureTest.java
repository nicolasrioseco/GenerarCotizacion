package ClasesPrincipales;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, 
//tags={"~@wip"}, 
features = "src/test/resources/features", format = {
		"pretty",
		"html:target/reports/cucumber",
		"json:target/reports/cucumber.json",
		"junit:target/reports/cucumber.xml"
		})
public class RunFeatureTest {

}
