package com.epam.task4.controller.command.impl;

import com.epam.task4.bean.Request;
import com.epam.task4.controller.command.Command;
import com.epam.task4.service.ClientService;
import com.epam.task4.service.exception.ServiceException;
import com.epam.task4.service.factory.ServiceFactory;

public class Registration implements Command {

	@Override
	public String execute(Request request) {
		String response = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();

		try {
			clientService.init();
			clientService.registration(request);
			response = "User added successfully";
		} catch (ServiceException e) {
			response = "Error during registration procedure";
		} finally {
			clientService.destroy();
		}
		return response;
	}
}