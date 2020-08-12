package org.dxctraining.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.dxctraining.dao.*;
import org.dxctraining.entities.Book;
import org.dxctraining.exceptions.*;

@Service
public class BookServiceImpl implements IBookService {
	
@Autowired
	private IBookDao bookdao;

	@Override
	public Book findById(String id) {
		checkId(id);
		Book book = dao.findById(id);
		return book;
	}

	private void checkId(String id) {
		if(id==null) {
			throw new InvalidArgumentException("id can't be null");
		
				}
			}
			public void checkCost(double cost) {
				if (cost<1) {
					throw new InvalidArgumentException("cost can't be negative");
				}
			}
			
			public void checkBook(Book book) {
				if(book==null) {
					throw new InvalidArgumentException("book cant be null or empty");
						
				}
			}		
	
@Override
		 public List<Book> findAll() {
		 List<Book>list=dao.findAll();
		 return list;

	}

	@Override
	public Book updateCost(String id, double cost) {
		checkId(id);
		checkCost(cost);
		Book book=dao.updateCost(id, cost);
		return book;
	}

	@Override
	public void add(Book book) {
		checkBook(book);
		dao.add(book);
	}

	@Override
	public Book update(Book book) {
		checkBook(book);
		book =dao.update(book);
	    return book;
	}

	@Override
	public void delete(String id) {
		checkId(id);
		dao.delete(id);
	}

}
