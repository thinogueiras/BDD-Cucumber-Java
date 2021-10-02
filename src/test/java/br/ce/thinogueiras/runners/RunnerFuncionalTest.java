package br.ce.thinogueiras.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"br.ce.thinogueiras.steps", "br.ce.thinogueiras.config"},
		tags = "@funcionais",
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"}, 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)

public class RunnerFuncionalTest
{
	@BeforeClass
	public static void resetDB()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thiago.santos\\Selenium-Drivers\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
		driver.findElement(By.id("email")).sendKeys("thiagonogueira@hotmail.com.br");
		driver.findElement(By.id("senha")).sendKeys("625836");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}
