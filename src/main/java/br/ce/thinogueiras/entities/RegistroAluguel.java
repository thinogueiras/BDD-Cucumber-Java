package br.ce.thinogueiras.entities;

import java.util.Date;

public class RegistroAluguel
{
	private int precoAluguel;
	private Date dataEntrega;
	private int pontuacao;

	public int getPrecoAluguel() 
	{
		return precoAluguel;
	}

	public void setPrecoAluguel(int precoAluguel) 
	{
		this.precoAluguel = precoAluguel;
	}

	public Date getDataEntrega()
	{
		return dataEntrega;
	}

	public void setDataEntrega(Date time) 
	{
		dataEntrega = time;
	}

	public int getPontuacao() 
	{
		return pontuacao;
	}
	
	public void setPontuacao(int pontuacao) 
	{
		this.pontuacao = pontuacao;
	}
}
