package com.epam.task4.service;

import com.epam.task4.bean.Request;
import com.epam.task4.service.exception.ServiceException;

public interface ClientService {
	void init() throws ServiceException;
	void registration(Request request) throws ServiceException;
	boolean signIn(Request request) throws ServiceException;
	boolean signOut(Request request) throws ServiceException;
	void destroy();
}
