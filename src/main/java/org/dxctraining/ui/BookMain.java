package org.dxctraining.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;

import org.dxctraining.exceptions.*;
import org.dxctraining.entities.*;
import org.dxctraining.service.*;
import org.dxctraining.*;

@Component
public class BookMain {
	@Autowired
	private IBookService bookservice;
	public static void main(String[] args) {
		BookMain demo = new BookMain();
		demo.runApp();
	}
	@PostConstruct
	public void runApp() {
		try {
			Author a1= new Author("a12","kalam");
			Author a2= new Author("a13","paulo ");
			Book b1=new Book(1);
			Book b2=new Book(1);
			ItBook book1=new ItBook("a14 ","ignitedminds ",a1,500,b1, "english",1.0);
			service.add(book1);
			FictionBook book2=new FictionBook("a15 ","alchemist ",a2,600,b2, "shopkeeper ");
			service.add(book2);
			displayAll();
			}
		 catch (InvalidArgumentException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			catch (BookNotFoundException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			catch (Exception e) {
				e.printStackTrace();
				System.out.println("some thing went wrong");
			}

			
		}
		private void displayAll() {
			List<Book> list=service.findAll();
			for(Book book:list) {
				display(book);
			}
			
		}
		public void display(Book book) {
			
			System.out.println("Id is "+book.getId()+" book name "+book.getName()+" book number "+book.getBooknum()+"and cost is"+book.getCost());
			Author author=book.getAuthor();
			System.out.println("Author id "+author.getId()+" and name "+author.getName());
			
			if(book instanceof FictionBook) {
				FictionBook fiction=(FictionBook) book;
				System.out.println("character name is "+fiction.getCharactername());
			}
			if(book instanceof ItBook) {
				ItBook it=(ItBook) book;
				System.out.println("language is "+it.getLanguage()+" and version is "+it.getVersion());
			}
		}
	}
		