package com.epam.task4.service.util;

import com.epam.task4.bean.Request;

public class Validator {
	public static boolean validateNews(Request request){
		if (request == null || request.getTitle() == null || request.getCategory() == null || request.getContent() == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateTitle(Request request){
		if (request == null || request.getTitle() == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateCategory(Request request){
		if (request == null || request.getCategory() == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateUser(Request request){
		if (request == null || request.getLogin() == null || request.getPassword() == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validateLogin(Request request){
		if (request == null || request.getLogin() == null) {
			return false;
		}
		return true;
	}
}
