package com.epam.task4.dao;

import java.util.HashSet;

import com.epam.task4.bean.News;
import com.epam.task4.bean.Request;
import com.epam.task4.dao.exception.DAOException;

public interface NewsDAO {
	void init() throws DAOException;
	void addNews(Request request) throws DAOException;
	HashSet<News> findByTitle(Request request) throws DAOException;
    HashSet<News> findByCategory(Request request) throws DAOException;
    void destroy();
}