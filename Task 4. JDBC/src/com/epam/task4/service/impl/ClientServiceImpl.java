package com.epam.task4.service.impl;

import com.epam.task4.bean.Request;
import com.epam.task4.dao.UserDAO;
import com.epam.task4.dao.exception.DAOException;
import com.epam.task4.dao.factory.DAOFactory;
import com.epam.task4.service.ClientService;
import com.epam.task4.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

	@Override
	public void init() throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			userDAO.init();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void registration(Request request) throws ServiceException {
		if (request == null || request.getLogin() == null || request.getPassword() == null) {
			throw new ServiceException("Incorrect request initialization");
		}

		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			userDAO.registration(request);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean signIn(Request request) throws ServiceException {
		if (request == null || request.getLogin() == null || request.getPassword() == null) {
			throw new ServiceException("Incorrect request initialization");
		}

		boolean result = false;
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			result = userDAO.signIn(request);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public boolean signOut(Request request) throws ServiceException {
		if (request == null) {
			throw new ServiceException("Incorrect request initialization");
		}

		boolean result = false;
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			result = userDAO.signOut(request);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public void destroy() {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		userDAO.destroy();
	}
}
