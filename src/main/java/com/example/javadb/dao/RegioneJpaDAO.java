package com.example.javadb.dao;

import com.example.javadb.entities.Regione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class RegioneJpaDAO implements DAO<Regione, Integer>{
	
	private static final Logger log = LogManager.getLogger(RegioneJpaDAO.class);
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
	private static final String findAllQuery = "select r from Regione r order by r.id"; // JPQL
	@Override
	public Regione findById(Integer key) {
		unsupportedOperation("findById");
		return null;
	}

	@Override
	public List<Regione> findAll() {
		List<Regione> regione = null;

		EntityManager em = emf.createEntityManager();

		TypedQuery<Regione> qry = em.createQuery(findAllQuery, Regione.class);

		regione = qry.getResultList();

		em.close(); // shutdown di EntityManager quando non serve più

		return regione;
	}

	@Override
	public Regione create(Regione entity) {
		unsupportedOperation("findById");
		return null;
	}

	@Override
	public Integer update(Regione entity) {
		unsupportedOperation("findById");
		return null;
	}

	@Override
	public Integer delete(Integer key) {
		unsupportedOperation("findById");
		return null;
	}
	

}
