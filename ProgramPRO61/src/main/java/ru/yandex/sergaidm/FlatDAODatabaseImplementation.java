package ru.yandex.sergaidm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class FlatDAODatabaseImplementation implements FlatDAO {

	private EntityManager entityManager;

	public FlatDAODatabaseImplementation() {
		entityManager = ManagerDAO.getEntityManager();
	}

	@Override
	public void insert(Flat flat) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(flat);
			entityManager.getTransaction().commit();
		} catch (IllegalStateException e) {
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public List<Flat> getFlatsList() {
		List<Flat> flats = new ArrayList<>();
		try {
			Query query = entityManager.createQuery("SELECT f FROM Flat f ORDER BY id", Flat.class);
			flats = (List<Flat>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return flats;
	}

	@Override
	public Flat getFlatByID(int id) {
		Flat flat = new Flat();
		Query query = entityManager.createQuery("SELECT f FROM Flat f WHERE f.id = :id", Flat.class);
		query.setParameter("id", id);
		flat = (Flat) query.getSingleResult();
		return flat;
	}

	@Override
	public List<Flat> getFlatsByAddress(String address) {
		List<Flat> flatsByAddress = new ArrayList<>();
		try {
			Query query = entityManager.createQuery("SELECT f FROM Flat f WHERE LOWER(f.address) LIKE :address ORDER BY id", Flat.class);
			query.setParameter("address", "%" + address + "%");
			flatsByAddress = (List<Flat>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return flatsByAddress;
	}

	@Override
	public List<Flat> getFlatsByRoomsNumber(int roomsNumber) {
		List<Flat> flatsByRoomsNumber = new ArrayList<>();
		try {
			Query query = entityManager.createQuery("SELECT f FROM Flat f WHERE f.roomsNumber =:roomsNumber ORDER BY id", Flat.class);
			query.setParameter("roomsNumber", roomsNumber);
			flatsByRoomsNumber = (List<Flat>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return flatsByRoomsNumber;
	}

	@Override
	public List<Flat> getFlatsByFloor(int floor) {
		List<Flat> flatsByFloor = new ArrayList<>();
		try {
			Query query = entityManager.createQuery("SELECT f FROM Flat f WHERE f.floor =:floor ORDER BY id",
					Flat.class);
			query.setParameter("floor", floor);
			flatsByFloor = (List<Flat>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return flatsByFloor;
	}

	@Override
	public List<Flat> getFlatsByPrice(double begin, double end, String currency) {
		List<Flat> flatsByPrice = new ArrayList<>();
		try {
			Query query = entityManager.createQuery("SELECT f FROM Flat f WHERE f.price.cost >= :begin AND f.price.cost <= :end AND f.price.currency = :currency ORDER BY id", Flat.class);
			query.setParameter("currency", currency);
			query.setParameter("begin", begin);
			query.setParameter("end", end);
			flatsByPrice = (List<Flat>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return flatsByPrice;
	}

	@Override
	public void update(int id, String address, int roomsNumber, int floor, Price price) throws IllegalStateException {
		Flat flat = entityManager.getReference(Flat.class, id);
		entityManager.getTransaction().begin();
		flat.setAddress(address);
		flat.setRoomsNumber(roomsNumber);
		flat.setFloor(floor);
		flat.setPrice(price);
		entityManager.getTransaction().commit();
	}

	@Override
	public void delete(int id) {
		try {
			Flat flat = entityManager.getReference(Flat.class, id);
			entityManager.getTransaction().begin();
			entityManager.remove(flat);
			entityManager.getTransaction().commit();
		} catch (IllegalStateException e) {
			entityManager.getTransaction().rollback();
		}
	}

}
