package org.dxctraining.service;

import java.util.List;

import org.dxctraining.entities.Book;

public interface IBookService {

	Book findById(String id);
	List<Book> findAll();
	Book updateCost(String id,double cost);
	void add(Book book);
	Book update(Book book);
	void delete(String id);

}