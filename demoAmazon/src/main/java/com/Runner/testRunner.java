package com.Runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\pc\\eclipse-workspace\\demoAmazon\\demoAmazon\\Feature\\Login.feature"
		,glue= "com.Stepdef"
		//,plugin = {"pretty","html:target/cucumber-reports" }
		,plugin ={"com.cucumber.listener.ExtentCucumberFormatter:C:\\Users\\pc\\eclipse-workspace\\Reports\\Report.html"}
		,//tags = "@Smoke_test"
		tags="@scenario1,@scenario2,@scenario3,@scenario4"
				//,tags="@scenario5"
		
)

public class testRunner {


}
