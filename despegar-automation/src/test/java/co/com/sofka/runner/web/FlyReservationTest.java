package co.com.sofka.runner.web;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/reserve_fly.feature",
        glue = "co.com.sofka.stepdefinitions.web",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true
)
public class FlyReservationTest{
}
