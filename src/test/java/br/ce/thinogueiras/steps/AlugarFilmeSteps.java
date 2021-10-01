package br.ce.thinogueiras.steps;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import br.ce.thinogueiras.entities.Filme;
import br.ce.thinogueiras.entities.RegistroAluguel;
import br.ce.thinogueiras.enums.TipoAluguel;
import br.ce.thinogueiras.services.AluguelService;
import br.ce.thinogueiras.utils.DateUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AlugarFilmeSteps 
{
	private Filme filme;
	private AluguelService aluguelService = new AluguelService();
	private RegistroAluguel registroAluguel;
	private String erro;
	private TipoAluguel tipoAluguel;
	
	@Given("^um filme$")
	public void umFilme(DataTable table) throws Throwable
	{
	    Map<String, String> map = table.asMap(String.class, String.class);
	    filme = new Filme();
	    filme.setEstoque(Integer.parseInt(map.get("estoque")));
	    filme.setAluguel(Integer.parseInt(map.get("preco")));
	    String tipo = map.get("tipo");
	    tipoAluguel = 
	    	tipo.equals("comum")? TipoAluguel.COMUM: 
			tipo.equals("extendido")? TipoAluguel.EXTENDIDO: 
			TipoAluguel.SEMANAL;
	}
	
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
		try
		{
			registroAluguel = aluguelService.alugar(filme, tipoAluguel);
			
		}
		catch(RuntimeException e)
		{
			erro = e.getMessage();
		};
	}

	@Then("^o preço do aluguel será R\\$ (\\d+)$")
	public void oPreçoDoAluguelSeráR$(int arg1) throws Throwable 
	{
	    assertEquals(arg1, registroAluguel.getPrecoAluguel());
	}
	
	@And("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable 
	{
	    assertEquals(arg1, filme.getEstoque());
	}		

	@Then("^não será possível por falta de estoque$")
	public void nãoSeráPossívelPorFaltaDeEstoque() throws Throwable
	{
		assertEquals("Filme sem estoque", erro);
	}
	
	@Then("^não será possível por falta de preço$")
	public void nãoSeráPossívelPorFaltaDePreço() throws Throwable
	{
		assertEquals("Filme sem preço", erro);
	}
	
	@Given("^que o tipo do aluguel seja (.*)$")
	public void queOTipoDoAluguelSeja(String tipo) throws Throwable 
	{
		tipoAluguel = tipo.equals("comum")? TipoAluguel.COMUM: 
			tipo.equals("extendido")? TipoAluguel.EXTENDIDO: 
			TipoAluguel.SEMANAL;
	}

	@Then("^a data de entrega será em (\\d+) dias?$")
	public void aDataDeEntregaSeráEmDias(int arg1) throws Throwable 
	{
		Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
		Date dataReal = registroAluguel.getDataEntrega();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		assertEquals(dateFormat.format(dataEsperada), dateFormat.format(dataReal));
	}

	@Then("^a pontuação recebida será de (\\d+) pontos?$")
	public void aPontuaçãoRecebidaSeráDePontos(int arg1) throws Throwable 
	{
		assertEquals(arg1, registroAluguel.getPontuacao());
	}
}
