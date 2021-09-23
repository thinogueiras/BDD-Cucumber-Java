package br.ce.thinogueiras.steps;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.ce.thinogueiras.entities.Filme;
import br.ce.thinogueiras.entities.RegistroAluguel;
import br.ce.thinogueiras.services.AluguelService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlugarFilmeSteps 
{
	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private RegistroAluguel registroAluguel;
	
	@Given("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable
	{
	    filme = new Filme();
	    filme.setEstoque(arg1);
	}

	@And("^que o preço do aluguel seja R\\$ (\\d+)$")
	public void queOPreçoDoAluguelSejaR$(int arg1) throws Throwable 
	{
		filme.setAluguel(arg1);
	}

	@When("^alugar$")
	public void alugar() throws Throwable 
	{
		registroAluguel = aluguelService.alugar(filme);
	}

	@Then("^o preço do aluguel será R\\$ (\\d+)$")
	public void oPreçoDoAluguelSeráR$(int arg1) throws Throwable 
	{
	    assertEquals(arg1, registroAluguel.getPrecoAluguel());
	}

	@And("^a data de entrega será no dia seguinte$")
	public void aDataDeEntregaSeráNoDiaSeguinte() throws Throwable 
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		
		Date dataRetorno = registroAluguel.getDataEntrega();
		Calendar calDataRetorno = Calendar.getInstance();
		calDataRetorno.setTime(dataRetorno);
		
		assertEquals(calendar.get(Calendar.DAY_OF_MONTH), calDataRetorno.get(Calendar.DAY_OF_MONTH));
		assertEquals(calendar.get(Calendar.MONTH), calDataRetorno.get(Calendar.MONTH));
		assertEquals(calendar.get(Calendar.YEAR), calDataRetorno.get(Calendar.YEAR));
	}

	@And("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable 
	{
	    assertEquals(arg1, filme.getEstoque());
	}
}
