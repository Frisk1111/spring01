package com.example.javadb.dao;

import com.example.javadb.entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ClientiJpaDAO  implements DAO<Cliente, Integer> {

	private static final Logger log = LogManager.getLogger(ClientiJpaDAO.class);

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

	private static final String findAllQuery = "select c from Cliente c order by c.cognome"; // JPQL

	@Override
	public Cliente findById(Integer key) {
		unsupportedOperation("findById");
		return null;
	}

	@Override
	public List<Cliente> findAll() {
		List<Cliente> clienti = null;

		EntityManager em = emf.createEntityManager();

		TypedQuery<Cliente> qry = em.createQuery(findAllQuery, Cliente.class);

		clienti = qry.getResultList();

		em.close(); // shutdown di EntityManager quando non serve più

		return clienti;
	}

	@Override
	public Cliente create(Cliente entity) {
		unsupportedOperation("create");
		return null;
	}

	@Override
	public Integer update(Cliente entity) {
		unsupportedOperation("update");
		return null;
	}

	@Override
	public Integer delete(Integer key) {
		unsupportedOperation("delete");
		return null;
	}

}
