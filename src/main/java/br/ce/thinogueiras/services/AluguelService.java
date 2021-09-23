package br.ce.thinogueiras.services;

import java.util.Calendar;

import br.ce.thinogueiras.entities.Filme;
import br.ce.thinogueiras.entities.RegistroAluguel;

public class AluguelService 
{
	public RegistroAluguel alugar(Filme filme)
	{
		RegistroAluguel registroAluguel = new RegistroAluguel();
		registroAluguel.setPrecoAluguel(filme.getAluguel());
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		registroAluguel.setDataEntrega(calendar.getTime());
		filme.setEstoque(filme.getEstoque() - 1);
		
		return registroAluguel;
	}
	
}
