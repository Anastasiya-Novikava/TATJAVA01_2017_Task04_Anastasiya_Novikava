package com.epam.task4.controller.command;

public enum  CommandName {

    REGISTRATION("Registration"),
    SIGN_IN("Sign_in"),
    SIGN_OUT("Sign_out"),
    ADD_NEWS("Add_news"),
    FIND_BY_TITLE("Find_by_title"),
    FIND_BY_CATEGORY("Find_by_category"),
    WRONG_REQUEST("Wrong_request");
	
	String name;

    CommandName(String name) {
        this.name = name;
    }
}

