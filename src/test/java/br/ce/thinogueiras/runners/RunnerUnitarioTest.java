package br.ce.thinogueiras.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = {"br.ce.thinogueiras.steps", "br.ce.thinogueiras.config"},
		tags = {"@unitários"},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"}, 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)

public class RunnerUnitarioTest
{
	
}
