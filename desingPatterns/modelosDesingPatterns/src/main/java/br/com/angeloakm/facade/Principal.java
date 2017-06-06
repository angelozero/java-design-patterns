package br.com.angeloakm.facade;

public class Principal {

	public static void main(String[] args) {

		/**
		 * Neste exemplo usamos a classe ContaDAO para isolar conexão com o
		 * banco e persistencia de dados
		 */

		Conta conta = new Conta();

		conta.setAgencia("agencia teste");
		conta.setBanco("banco teste");
		conta.setNumero("123456");
		conta.setTitular("angelo");

		ContaDAO.saveConta(conta);

		Conta conta2 = ContaDAO.getContaByContaId(2);

		ContaDAO.saveConta(conta2);

		ContaDAO.getAllContas().forEach(ct -> {
			System.out.println("\n" + ct.getTitular());
		});

		DataBaseConnection.closeConnection();

		System.out.println("\nFim da aplicação");

	}
}
