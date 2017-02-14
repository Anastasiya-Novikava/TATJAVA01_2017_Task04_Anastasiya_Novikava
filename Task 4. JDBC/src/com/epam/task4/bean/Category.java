package com.epam.task4.bean;

public enum Category {
	FILM("film"),
    DISK("disk"),
    BOOK("book");
    
    String category;

	Category(String category) {
        this.category = category;
    }
}
