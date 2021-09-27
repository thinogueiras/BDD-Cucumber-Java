package br.ce.thinogueiras.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InserirContaSteps 
{
	private WebDriver driver;
	
	@Given("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thiago.santos\\Selenium-Drivers\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
	}

	@When("^informo o usuário \"([^\"]*)\"$")
	public void informoOUsuário(String arg1) throws Throwable 
	{
	    driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@When("^a senha \"([^\"]*)\"$")
	public void aSenha(String arg1) throws Throwable
	{
		driver.findElement(By.name("senha")).sendKeys(arg1);
	}

	@When("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable
	{
		driver.findElement(By.tagName("button")).click();
	}

	@Then("^visualizo a página inicial$")
	public void visualizoAPáginaInicial() throws Throwable
	{
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		assertEquals("Bem vindo, Thiago Nogueira dos Santos!", texto);		
	}

	@When("^seleciono Contas$")
	public void selecionoContas() throws Throwable
	{
	    driver.findElement(By.linkText("Contas")).click();	    
	}

	@When("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable 
	{
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@When("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String arg1) throws Throwable
	{
	    driver.findElement(By.name("nome")).sendKeys(arg1);
	}

	@When("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable
	{
		driver.findElement(By.tagName("button")).click();
	}

	@Then("^a conta é inserida com sucesso$")
	public void aContaÉInseridaComSucesso() throws Throwable
	{
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		assertEquals("Conta adicionada com sucesso!", texto);
	}
	
	@Then("^sou notificado que o nome da conta é obrigatório$")
	public void souNotificadoQueONomeDaContaÉObrigatório() throws Throwable
	{
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		assertEquals("Informe o nome da conta", texto);		
	}
	
	@Then("^sou notificado que já existe uma conta com esse nome$")
	public void souNotificadoQueJáExisteUmaContaComEsseNome() throws Throwable
	{
		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		assertEquals("Já existe uma conta com esse nome!", texto);
	}
	
	@Then("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String arg1) throws Throwable
	{
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
		assertEquals(arg1, texto);
	}
	
	@Before
	public void iniciar()
	{
		System.out.println("Começando aqui!!!");
	}
	
	@After
	public void closeBrowser() 
	{
		driver.quit();
		System.out.println("Terminando aqui!!!");
	}	
}
