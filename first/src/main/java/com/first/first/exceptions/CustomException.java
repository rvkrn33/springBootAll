package com.first.first.exceptions;

public class CustomException extends Exception{

	public CustomException(String msg){
		System.out.println("===> "+msg);
	}
}
