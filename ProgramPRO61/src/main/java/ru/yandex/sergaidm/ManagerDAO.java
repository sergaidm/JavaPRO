package ru.yandex.sergaidm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerDAO {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate");
	private static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

	public ManagerDAO() {
		super();
	}

	public FlatDAO getFlatDAO() {
		return new FlatDAODatabaseImplementation();
	}

}
