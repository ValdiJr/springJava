package org.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.bookstore.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;

	public void save(Product product) {
		manager.persist(product);
	}
	public List<Product> list() {
		return manager.createQuery("select distinct(p) from "
				+ "Product p",Product.class)
		.getResultList();
		}

	
} 