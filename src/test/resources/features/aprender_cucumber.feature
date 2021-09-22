Feature: Aprender Cucumber

@sprint1 @critical
Scenario: Deve executar especificação
	Given que criei o arquivo corretamente
	When executá-lo
	Then a especificação deve finalizar com sucesso

@sprint1 @critical	
Scenario: Deve incrementar contador
	Given que o valor do contador é 15
	When eu incrementar em 3
	Then o valor do contador será 18

@sprint1 @critical	
Scenario: Deve incrementar contador
	Given que o valor do contador é 123
	When eu incrementar em 35
	Then o valor do contador será 158

@sprint2
Scenario: Deve calcular atrado na entrega
	Given que a entrega é dia 05/04/2021
	When a entrega atrasar em 2 dias
	Then a entrega será efetuada em 07/04/2021
	
Scenario: Deve calcular atrado na entrega da China
	Given que a entrega é dia 05/04/2021
	When a entrega atrasar em 2 meses
	Then a entrega será efetuada em 05/06/2021
	
Scenario: Deve criar steps genéricos para estes passos
    Given que o ticket é AF345
    Given que o valor da passagem é R$ 230,45
    Given que o nome do passageiro é "Fulano da Silva"
    Given que o telefone do passageiro é 9999-9999
    When criar os steps
    Then o teste vai funcionar

Scenario: Deve reaproveitar os steps "Given" do Scenario anterior
    Given que o ticket é AB167
    And que o ticket especial é AB167
    And que o valor da passagem é R$ 1120,23
    And que o nome do passageiro é "Cicrano de Oliveira"
    And que o telefone do passageiro é 9888-8888

@ignore
Scenario: Deve negar todos os steps "Given" dos Scenarios anteriores
    Given que o ticket é CD123
    Given que o ticket é AG1234
    Given que o valor da passagem é R$ 1.1345,56
    Given que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
    Given que o telefone do passageiro é 1234-5678
    Given que o telefone do passageiro é 999-2223