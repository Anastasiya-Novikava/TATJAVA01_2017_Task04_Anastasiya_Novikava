package com.epam.task4.controller.command.impl;

import com.epam.task4.bean.Request;
import com.epam.task4.controller.command.Command;
import com.epam.task4.service.CatalogService;
import com.epam.task4.service.exception.ServiceException;
import com.epam.task4.service.factory.ServiceFactory;

public class AddNews implements Command {

	@Override
	public String execute(Request request) {
		String response = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		CatalogService catalogService = serviceFactory.getCatalogService();

		try {
			catalogService.init();
			catalogService.addNews(request);
			response = "News added successfully";
		} catch (ServiceException e) {
			response = "Error during add procedure";
		} finally {
			catalogService.destroy();
		}
		return response;
	}
}