package br.ce.thinogueiras.steps;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static org.junit.Assert.assertEquals;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import br.ce.thinogueiras.converters.DateConverter;

public class AprenderCucumberSteps {
	
	private Date entrega = new Date();	
	
	@Given("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable
	{
		
	}

	@When("^executá-lo$")
	public void executáLo() throws Throwable
	{
	    
	}

	@Then("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable
	{
	    
	}
	
	private int contador = 0;
	
	@Given("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable
	{
	    contador = arg1;
	}

	@When("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable
	{
	    contador += arg1;
	}

	@Then("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) throws Throwable
	{	    
	    assertEquals(arg1, contador);	    
	}
	
	@Given("^que a entrega é dia (.*)$")
	public void queAEntregaÉDia(@Transform(DateConverter.class) Date data) throws Throwable {
		entrega = data;	
	}

	@When("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable 
	{
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(entrega);
	    if(tempo.equals("dias"))
	    {
	    	calendar.add(DAY_OF_MONTH, arg1);
	    }
	    if(tempo.equals("meses"))
	    {
	    	calendar.add(MONTH, arg1);	    		    	
	    }
	    entrega = calendar.getTime();
	}

	@Then("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuadaEm(String data) throws Throwable {
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = format.format(entrega);
	    assertEquals(data, dataFormatada);
	}
	
	@Given("^que o ticket( especial)? é A.(\\d{3})$")
	public void queOTicketÉAF(String tipo, String arg1) throws Throwable 
	{
	    
	}

	@Given("^que o valor da passagem é R\\$ (.*)$")
	public void queOValorDaPassagemÉR$(Double valor) throws Throwable 
	{
		
	}

	@Given("^que o nome do passageiro é \"(.{5,20})\"$")
	public void queONomeDoPassageiroÉ(String arg1) throws Throwable
	{
	    
	}

	@Given("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
	public void queOTelefoneDoPassageiroÉ(String telefone) throws Throwable
	{
	   
	}

	@When("^criar os steps$")
	public void criarOsSteps() throws Throwable 
	{
	    
	}

	@Then("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable
	{
	    
	}
}
