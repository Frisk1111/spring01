package com.example.javadb.dao;

import java.util.List;

/**
 * Data Access Object
 * Esprime specifica per operazioni CRUD
 * Create
 * Update
 * Retrieve
 * Delete
 *
 * @param <T>
 * @param <K>
 */
public interface DAO<T, K> {

	T findById(K key); // Retrieve

	List<T> findAll(); // Retrieve

	T create(T entity); // Create

	Integer update(T entity); // Update

	Integer delete(K key); // Delete

	public default void unsupportedOperation(String method) {
		String str = String.format("Metodo %s non ancora implementato", method);
		throw new UnsupportedOperationException(str);
	}

}
