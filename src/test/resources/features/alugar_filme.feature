Feature: Alugar filme
	Como um usuário
	Eu quero cadastrar aluguéis de filmes
	Para controlar preços e datas de entrega

Scenario: Deve alugar um filme com sucesso
	Given um filme
		| estoque |   2   |
		| preco   |   3   |
		| tipo    | comum |	
	When alugar
	Then o preço do aluguel será R$ 3
	And a data de entrega será em 1 dia
	And o estoque do filme será 1 unidade
	
Scenario: Não deve alugar filme sem estoque
	Given um filme com estoque de 0 unidades
	When alugar
	Then não será possível por falta de estoque
	And o estoque do filme será 0 unidade

Scenario Outline: Deve dar condições conforme tipo de aluguel
	Given um filme com estoque de 2 unidades
	And que o preço do aluguel seja R$ <preco>
	And que o tipo do aluguel seja <tipo>
	When alugar
	Then o preço do aluguel será R$ <valor>
	And a data de entrega será em <qtdeDias> dias
	And a pontuação recebida será de <qtdePontuacao> pontos
	
Examples:
	| preco |   tipo    | valor | qtdeDias | qtdePontuacao |
	|   4   | extendido |   8   |    3     |      2        |
	|   4   |   comum   |   4   |    1     |      1        |
	|   5   |  semanal  |  15   |    7     |      3        |
	|  10   | extendido |  20   |    3     |      2        |
	