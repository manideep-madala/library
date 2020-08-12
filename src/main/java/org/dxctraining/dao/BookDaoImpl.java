package org.dxctraining.dao;
import org.dxctraining.entities.*;
import org.dxctraining.exceptions.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.*;


	@Repository
	public class BookDaoImpl implements IBookDao {
	
	private Map<String,Book> store=	BookStore.getStore();
			private int generateid;
	private String generateid() {
		generateid++;
		String idstr=String.valueOf(generateid);
		return idstr;
	}
		@Override
	public Book findById(String id) {
		Book book=store.get(id);
		if(book==null) {
			throw new BookNotFoundException("book not found for the id ");
		}
		return book;
	}
	
	@Override
	public List<Book> findAll() {
		Collection<Book> values=store.values();
		List<Book> list=new ArrayList<>();
		for(Book value:values) {
			list.add(value);
		}
		return list;
	}

	@Override
	public Book updateCost(String id, double cost) {
		Book book=findById(id);
		book.setCost(cost);
		return book;
	}

	@Override
	public void add(Book book) {
		String id=book.getId();
		store.put(id, book);
		book.setId(id);
		
	}

	@Override
	public Book update(Book book) {
		String id=book.getId();
		return book;
	}

	@Override
	public void delete(String id) {
		store.remove(id);
	}

}