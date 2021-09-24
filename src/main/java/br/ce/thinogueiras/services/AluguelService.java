package br.ce.thinogueiras.services;

import br.ce.thinogueiras.entities.Filme;
import br.ce.thinogueiras.entities.RegistroAluguel;
import br.ce.thinogueiras.utils.DateUtils;

public class AluguelService 
{
	public RegistroAluguel alugar(Filme filme, String tipoAluguel)
	{
		if(filme.getEstoque() == 0) 
			throw new RuntimeException("Filme sem estoque");
		
		RegistroAluguel registroAluguel = new RegistroAluguel();
		if("extendido".equals(tipoAluguel))
		{
			registroAluguel.setPrecoAluguel(filme.getAluguel() * 2);
			registroAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
			registroAluguel.setPontuacao(2);
		}
		else
		{
			registroAluguel.setPrecoAluguel(filme.getAluguel());
			registroAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
			registroAluguel.setPontuacao(1);
		}	
		
		filme.setEstoque(filme.getEstoque() - 1);
		
		return registroAluguel;
	}	
}
