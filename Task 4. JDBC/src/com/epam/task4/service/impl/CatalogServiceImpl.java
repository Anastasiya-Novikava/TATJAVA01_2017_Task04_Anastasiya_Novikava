package com.epam.task4.service.impl;

import java.util.HashSet;

import com.epam.task4.bean.News;
import com.epam.task4.bean.Request;
import com.epam.task4.dao.NewsDAO;
import com.epam.task4.dao.exception.DAOException;
import com.epam.task4.dao.factory.DAOFactory;
import com.epam.task4.service.CatalogService;
import com.epam.task4.service.exception.ServiceException;

public class CatalogServiceImpl implements CatalogService {

	@Override
	public void init() throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
			newsDAO.init();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addNews(Request request) throws ServiceException {
		if (request == null || request.getTitle() == null || request.getCategory() == null || request.getContent() == null) {
			throw new ServiceException("Incorrect news initialization");
		}

		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
			newsDAO.addNews(request);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public HashSet<News> findByTitle(Request request) throws ServiceException {
		if (request == null || request.getTitle() == null) {
			throw new ServiceException("Incorrect title initialization");
		}
		
		HashSet<News> result = new HashSet<>();
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
			result = newsDAO.findByTitle(request);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public HashSet<News> findByCategory(Request request) throws ServiceException {
		if (request == null || request.getCategory() == null) {
			throw new ServiceException("Incorrect category initialization");
		}
		HashSet<News> result = new HashSet<>();
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
			result = newsDAO.findByCategory(request);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public void destroy() {
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
		newsDAO.destroy();
	}

}
