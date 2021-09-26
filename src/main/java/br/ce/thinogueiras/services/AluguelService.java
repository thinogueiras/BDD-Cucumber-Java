package br.ce.thinogueiras.services;

import br.ce.thinogueiras.entities.Filme;
import br.ce.thinogueiras.entities.RegistroAluguel;
import br.ce.thinogueiras.enums.TipoAluguel;
import br.ce.thinogueiras.utils.DateUtils;

public class AluguelService 
{
	public RegistroAluguel alugar(Filme filme, TipoAluguel tipoAluguel)
	{
		if(filme.getEstoque() == 0) 
			throw new RuntimeException("Filme sem estoque");
		
		RegistroAluguel registroAluguel = new RegistroAluguel();
		
		switch (tipoAluguel)
		{
		case COMUM:
			registroAluguel.setPrecoAluguel(filme.getAluguel());
			registroAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
			registroAluguel.setPontuacao(1);			
			break;
			
		case EXTENDIDO:
			registroAluguel.setPrecoAluguel(filme.getAluguel() * 2);
			registroAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
			registroAluguel.setPontuacao(2);			
			break;
			
		case SEMANAL:
			registroAluguel.setPrecoAluguel(filme.getAluguel() * 3);
			registroAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
			registroAluguel.setPontuacao(3);			
			break;		
		}
				
		filme.setEstoque(filme.getEstoque() - 1);		
		return registroAluguel;
	}	
}
