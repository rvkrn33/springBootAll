package com.ioc.container;

public class Notebook {
	
	private String text;
	
	Notebook(){
		System.out.println("NOtebook loaded");
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
