package co.com.sofkau.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "co.com.sofkau.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@todos",
        plugin = {
                "rerun:build/failedScenarios.txt"
        }
)
public class GeneralTest {
}
