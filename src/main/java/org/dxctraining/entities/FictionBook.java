package org.dxctraining.entities;
public class FictionBook extends Book {
	private String charactername;
	private double cost;
	
	public FictionBook(String id,String name,Author author,double cost,Book book,String charactername) {
		super(id,name,book,author,cost);
		this.charactername=charactername;
	
	}

	public String getCharactername() {
		return charactername;
	}

	public void setCharactername(String charactername) {
		this.charactername = charactername;
	}

}
