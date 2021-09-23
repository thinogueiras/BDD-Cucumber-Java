Feature: Alugar filme
	Como um usuário
	Eu quero cadastrar aluguéis de filmes
	Para controlar preços e datas de entrega

Scenario: Deve alugar um filme com sucesso
	Given um filme com estoque de 2 unidades
	And que o preço do aluguel seja R$ 3
	When alugar
	Then o preço do aluguel será R$ 3
	And a data de entrega será no dia seguinte
	And o estoque do filme será 1 unidade
	
#Scenario: Não deve alugar filme sem estoque
#	Given um filque com estoque de 0 unidades
#	When alugar
#	Then não será possível por falta de estoque
#	And o estoque do filme será 0 unidade

#Scenario: Deve dar condições especiais para categoria extendida
#	Given um filme com estoque de 2 unidades
#	And que o preço de aluguel seja R$ 4,00
#	And que o tipo do aluguel seja extendido
#	When alugar
#	Then o preço do aluguel será R$ 8,00
#	And a data de entrega será em 3 dias
#	And a pontuação recebida será de 2 pontos