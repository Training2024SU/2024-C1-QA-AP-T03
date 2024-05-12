package co.com.prueba.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/exito",
        glue = "co.com.prueba.stepdefinitions.exito",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@agregarproductoscarrito2",
        publish = true
)
public class ExitoTest {
}