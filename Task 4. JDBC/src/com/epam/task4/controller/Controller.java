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

		if (commandName.equals(CommandName.REGISTRATION)) {
			request.setLogin(arrayParametersRequest[0]);
			request.setPassword(arrayParametersRequest[1]);
		} else if (commandName.equals(CommandName.SIGN_IN)) {
			request.setLogin(arrayParametersRequest[0]);
			request.setPassword(arrayParametersRequest[1]);
		} else if (commandName.equals(CommandName.SIGN_OUT)) {
			request.setLogin(arrayParametersRequest[0]);
		} else if (commandName.equals(CommandName.ADD_NEWS)) {
			request.setTitle(arrayParametersRequest[0]);
			Category category = Category.valueOf(arrayParametersRequest[1].toUpperCase());
			request.setCategory(category);
			request.setContent(arrayParametersRequest[2]);
		} else if (commandName.equals(CommandName.FIND_BY_CATEGORY)) {
			Category category = Category.valueOf(arrayParametersRequest[0].toUpperCase());
			request.setCategory(category);
		} else if (commandName.equals(CommandName.FIND_BY_TITLE)) {
			request.setTitle(arrayParametersRequest[0]);
		}
	}
}