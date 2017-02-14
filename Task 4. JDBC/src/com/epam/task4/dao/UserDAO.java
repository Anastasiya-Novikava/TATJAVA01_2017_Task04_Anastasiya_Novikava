package com.epam.task4.dao;

import com.epam.task4.bean.Request;
import com.epam.task4.dao.exception.DAOException;

public interface UserDAO {
	void init() throws DAOException;
	void registration(Request request) throws DAOException;
	boolean signIn(Request request) throws DAOException;
	boolean signOut(Request request) throws DAOException;
	void destroy();
}
