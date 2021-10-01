@funcionais
Feature: Cadastro de contas

	Como um usuário 
	Gostaria de cadastrar contas
	Para que eu possa distribuir meu dinheiro de uma forma mais organizada

Background:
	Given que estou acessando a aplicação
	When informo o usuário "thiagonogueira@hotmail.com.br"
	And a senha "625836"
	And seleciono entrar
	Then visualizo a página inicial
	When seleciono Contas
	And seleciono Adicionar
	
Scenario Outline: Deve validar regras para cadastro de contas
	When informo a conta "<conta>"
	And seleciono Salvar
	Then recebo a mensagem "<mensagem>"
	
Examples:
	|        conta             |        mensagem                    |
	| Conta de Teste do Thiago | Conta adicionada com sucesso!      |
	|                          | Informe o nome da conta            |
	| Conta mesmo nome         | Já existe uma conta com esse nome! | 