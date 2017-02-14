package com.epam.task4.view;

import com.epam.task4.controller.Controller;

public class Runner {
	public static void main(String[] args){
		Controller controller = new Controller();
		System.out.println(controller.executeTask("Registration lool lool"));
		System.out.println(controller.executeTask("Sign_in newgeeet new sfc"));
		System.out.println(controller.executeTask("Sign_out tree"));
		System.out.println(controller.executeTask("Add_news df FILM sdaaadfgg"));
		System.out.println(controller.executeTask("Find_by_category disk"));
		System.out.println(controller.executeTask("Find_by_title Oscar_nominees"));
		System.out.println(controller.executeTask("asd admin"));
	}
}
