package DemoApplication.NopCommerce.Runners;

import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"classpath:features/OrangeHRMFeature/NopCommerce_Login.feature"},
		tags= {"@Functional"},
		glue = {"classpath:DemoApplication.NopCommerce.Selectors",
			   "classpath:DemoApplication.NopCommerce.Steps",
			   "classpath:DemoApplication.NopCommerce.StepDefinitions",
			   "classpath:DemoApplication.NopCommerce.Common",
			   "classpath:DemoApplication.NopCommerce.Runners"},
		plugin= {"pretty","html:target/Cucumber-html-report","json:target/cucumber-reports/Login.json","rerun:src/test/resources/rerun.txt"},
		strict=true
		)
public class NopCommerce_LoginFunctionality_Runner extends AbstractTestNGCucumberTests{

}
