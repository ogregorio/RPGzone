package com.rpgzonewebrest.dao;

import java.util.List;

public interface DAO<T, K>{
	public List<T> getAll();
	public T get(K key);
	public void add(T value);
	public void update(T value);
	public void delete(T value);
}
