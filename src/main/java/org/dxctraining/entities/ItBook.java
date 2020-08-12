package org.dxctraining.entities;


public class ItBook extends Book{
	private String language;
	private double version;
	
	public ItBook(String id,String name,Author author, double cost,Book book, String language,double version) {
		super(id,name,book,author, cost);
		this.language=language;
		this.version=version;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	
}

