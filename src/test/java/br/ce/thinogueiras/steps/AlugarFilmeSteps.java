package br.ce.thinogueiras.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlugarFilmeSteps 
{
	@Given("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable
	{
	    
	}

	@And("^que o preço do aluguel seja R\\$ (\\d+),(\\d+)$")
	public void queOPreçoDoAluguelSejaR$(int arg1, int arg2) throws Throwable 
	{
		
	}

	@When("^alugar$")
	public void alugar() throws Throwable 
	{
		
	}

	@Then("^o preço do aluguel será R\\$ (\\d+),(\\d+)$")
	public void oPreçoDoAluguelSeráR$(int arg1, int arg2) throws Throwable 
	{
	    
	}

	@And("^a data de entrega será no dia seguinte$")
	public void aDataDeEntregaSeráNoDiaSeguinte() throws Throwable 
	{
		
	}

	@And("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable 
	{
	    
	}
}
