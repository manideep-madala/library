package org.dxctraining.service;

import org.dxctraining.dao.*;
import org.dxctraining.entities.*;
import org.dxctraining.exceptions.*;
import java.util.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;




 class BookServiceImplTest {
	 BookServiceImpl service;
	 
	 @BeforeEach
	 void init() {
		 service=new BookServiceImpl();
	 }
	 
	 @AfterEach
	 public void clear() {
		 Map<String,Book> store=BookStore.getStore();
		 store.clear();
	 }
	 @Test
	 public void test_add1(){
		 Author author=new Author("h1","stephen king");
		 Book b1=new Book(73);
		 String id="bk1";
		 String name="misery";
		 Book book=new ItBook(id,name,author,1500,b1, "english",1.0);
		 service.add(book);
		 String storedid=book.getId();
		 Map<String,Book> store=BookStore.getStore();
		 Collection<Book> values=store.values();
		 int actualSize=values.size();
		 Assertions.assertEquals(1, actualSize);
		 Iterator<Book> iterator=values.iterator();
		 Book storedbook=iterator.next();
		 String actualId=storedbook.getId();
		 Author actualAuthor=storedbook.getAuthor();
		 Assertions.assertEquals(storedbook.getId(),storedid);
		 Assertions.assertEquals(id,actualId);
		 Assertions.assertEquals(name,storedbook.getName());
		 Assertions.assertEquals(author,actualAuthor);
		 
	 }
	 public void test_add2() {
		 Executable executable=()->service.add(null);	
		 Assertions.assertThrows(InvalidArgumentException.class, executable);	
	 }
	 @Test
	 public void testFindById() {
		 Map<String,Book> store=BookStore.getStore();
		 Author author=new Author("h1","stephen king");
		 Book b1=new Book(73);
		 String id="bk1";
		 String name="misery";
		 Book book=new ItBook(id,name,author,1500,b1, "english",1.0);
		 book.setId("bk1");
		 store.put(id,book);
		 Book actual=service.findById(id);
		 Assertions.assertNotNull(actual);
		 Assertions.assertEquals(id,actual.getId());
		 Assertions.assertEquals(name,actual.getName());
		 Author actualAuthor=actual.getAuthor();
		 Assertions.assertEquals(author.getId(),actualAuthor.getId());
		 Assertions.assertEquals(author.getName(),actualAuthor.getName());
		 
	 }
	 @Test
	 public void testFindById_2() {
		 String id="mk1";
		 Executable executable=()->service.findById(id);
		 Assertions.assertThrows(BookNotFoundException.class,executable);
	 }
}
