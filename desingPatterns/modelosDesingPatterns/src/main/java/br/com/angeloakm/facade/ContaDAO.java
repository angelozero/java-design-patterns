package br.com.angeloakm.facade;

import java.util.List;

import javax.persistence.EntityManager;

public class ContaDAO {

	private static final EntityManager manager = new DataBaseConnection().getConnection();

	public static void saveConta(Conta conta) {

		if (conta != null && conta.getId() != null && conta.getId() > 0) {
			updateConta(conta);
		} else {
			insertConta(conta);
		}
	}

	private static void insertConta(Conta conta) {

		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();

		System.out.println("\nConta salva com sucesso");
	}

	private static void updateConta(Conta conta) {

		manager.getTransaction().begin();
		manager.merge(conta);
		manager.getTransaction().commit();

		System.out.println("\nConta atualizada com sucesso");
	}

	public static Conta getContaByContaId(int id) {

		return manager.find(Conta.class, id);

	}

	public static List<Conta> getAllContas() {

		List<Conta> listContas = manager.createQuery("FROM Conta", Conta.class).getResultList();

		return listContas;
	}

}
