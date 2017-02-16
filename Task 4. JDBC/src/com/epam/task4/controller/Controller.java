package com.epam.task4.controller;

import com.epam.task4.bean.Category;
import com.epam.task4.bean.Request;
import com.epam.task4.controller.command.Command;
import com.epam.task4.controller.command.CommandName;

public final class Controller {
	private final CommandProvider provider = new CommandProvider();

	private final String DELIMETER = " ";

	public String executeTask(String inputLine) {
		String response;
		Command executionCommand;

		Request request = createRequest(inputLine);
		executionCommand = provider.getCommand(request.getCommandName().name());
		response = executionCommand.execute(request);

		return response;
	}

	private Request createRequest(String inputLine) {
		Request request = new Request();

		CommandName commandName;
		try {
			commandName = CommandName.valueOf(inputLine.substring(0, inputLine.indexOf(DELIMETER)).toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			commandName = CommandName.WRONG_REQUEST;
		}

		request.setCommand(commandName);
		String parametersRequest = inputLine.substring(inputLine.indexOf(DELIMETER) + 1);
		String[] arrayParametersRequest = parametersRequest.split(DELIMETER);
		setParametersRequest(request, arrayParametersRequest);

		return request;
	}

	private void setParametersRequest(Request request, String[] arrayParametersRequest) {
		CommandName commandName = request.getCommandName();

		switch(commandName){
		case REGISTRATION:
			request.setLogin(arrayParametersRequest[0]);
			request.setPassword(arrayParametersRequest[1]);
			break;
		case SIGN_IN:
			request.setLogin(arrayParametersRequest[0]);
			request.setPassword(arrayParametersRequest[1]);
			break;
		case SIGN_OUT:
			request.setLogin(arrayParametersRequest[0]);
			break;
		case ADD_NEWS:
			request.setTitle(arrayParametersRequest[0]);
			request.setCategory(Category.valueOf(arrayParametersRequest[1].toUpperCase()));
			request.setContent(arrayParametersRequest[2]);
			break;
		case FIND_BY_CATEGORY:
			request.setCategory(Category.valueOf(arrayParametersRequest[0].toUpperCase()));
			break;
		case FIND_BY_TITLE:
			request.setTitle(arrayParametersRequest[0]);
			break;
		case WRONG_REQUEST:
			break;
		}
	}
}