package co.com.sofka.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src/test/resources/features" },
        glue="co/com/sofka/stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@RutaCritica"
)
public class ExitoTest {
}
