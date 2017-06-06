package br.com.angeloakm.facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBaseConnection {

	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
	public static EntityManager createEntityManager;

	public EntityManager getConnection() {
		createEntityManager = factory.createEntityManager();
		return createEntityManager;
	}

	public static void closeConnection() {
		createEntityManager.close();
		factory.close();
		System.out.println("\nConexões fechadas com sucesso");
	}

}
