package com.epam.task4.service;

import java.util.HashSet;

import com.epam.task4.bean.News;
import com.epam.task4.bean.Request;
import com.epam.task4.service.exception.ServiceException;

public interface CatalogService {
	void init() throws ServiceException;
	void addNews(Request request) throws ServiceException;
	HashSet<News> findByTitle(Request request) throws ServiceException;
    HashSet<News> findByCategory(Request request) throws ServiceException;
    void destroy();
}
