package com.camelback.business;

public interface BusinessInterface<T> {

	// TODO: Inject DAO INTERFACE
	
	
	public int create(T model);

}