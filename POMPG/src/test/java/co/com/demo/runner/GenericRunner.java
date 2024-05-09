package co.com.demo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features ="/home/dan/Desktop/2024-C1-QA-AP-T03/POMPG/src/test/resources/features",
        glue = "co.com.demo.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        //tags = "@CriticalPath"
        //tags = "@PurchaseSeat"
        tags = "@PurchaseLuggage"
        //tags = "@ChangeFlight"
        //tags = "@Oneway"
        //tags = "@Ping"


)

public class GenericRunner {
}
