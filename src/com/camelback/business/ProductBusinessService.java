package com.camelback.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.camelback.beans.Product;
import com.camelback.data.DataAccessInterface;

public class ProductBusinessService implements ProductBusinessInterface<Product> {

	private DataAccessInterface<Product> dao;

	@Override
	public int addProduct(Product product) {
		return dao.create(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.findAll();
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	@Autowired
	public void setDao(DataAccessInterface<Product> dao) {
		this.dao = dao;
	}

}
