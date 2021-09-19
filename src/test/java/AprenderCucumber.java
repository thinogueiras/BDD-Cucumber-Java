import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class AprenderCucumber {

	@Given("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
		
	}

	@When("^executá-lo$")
	public void executáLo() throws Throwable {
	    
	}

	@Then("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {
	    
	}
	
	private int contador = 0;
	
	@Given("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
	    contador = arg1;
	}

	@When("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
	    contador += arg1;
	}

	@Then("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) throws Throwable {	    
	    assertEquals(arg1, contador);	    
	}
	
	Date entrega = new Date();
	
	@Given("^que a entrega é dia (\\d+)/(\\d+)/(\\d+)$")
	public void queAEntregaÉDia(int dia, int mes, int ano) throws Throwable {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.DAY_OF_MONTH, dia);
		calendar.set(calendar.MONTH, mes - 1);
		calendar.set(calendar.YEAR, ano);
		entrega = calendar.getTime();
	    
	}

	@When("^a entrega atrasar em (\\d+) dias$")
	public void aEntregaAtrasarEmDias(int arg1) throws Throwable {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(entrega);
	    calendar.add(calendar.DAY_OF_MONTH, arg1);
	    entrega = calendar.getTime();
	}

	@Then("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuadaEm(String data) throws Throwable {
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = format.format(entrega);
	    assertEquals(data, dataFormatada);
	}


}
