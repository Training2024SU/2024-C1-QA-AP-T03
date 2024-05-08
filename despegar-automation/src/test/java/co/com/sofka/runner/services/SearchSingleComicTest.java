package co.com.sofka.runner.services;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/search_single_comic.feature",
        glue = "co.com.sofka.stepdefinitions.services",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SearchSingleComicTest {
}
