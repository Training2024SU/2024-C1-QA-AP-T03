package co.com.demo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features ="/home/dan/Desktop/DemoQATest/src/test/resources/features/",
        glue = "co.com.demo.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class GenericRunner {
}
