package com.training.ifaces;

import java.util.Collection;

import com.training.exceptions.ElementNotFoundException;

public interface CrudRepository<T> {
	public boolean save(T obj);
	public Collection<T> findAll();
	public boolean delete(T obj) throws ElementNotFoundException ;

}