package org.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.bookstore.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Product product) {
		manager.persist(product);
	}
}