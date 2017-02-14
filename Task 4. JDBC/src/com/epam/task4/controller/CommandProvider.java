package com.epam.task4.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.task4.controller.command.Command;
import com.epam.task4.controller.command.CommandName;
import com.epam.task4.controller.command.impl.AddNews;
import com.epam.task4.controller.command.impl.FindByCategory;
import com.epam.task4.controller.command.impl.FindByTitle;
import com.epam.task4.controller.command.impl.Registration;
import com.epam.task4.controller.command.impl.SignIn;
import com.epam.task4.controller.command.impl.SignOut;
import com.epam.task4.controller.command.impl.WrongRequest;

final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.REGISTRATION, new Registration());
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.SIGN_OUT, new SignOut());
		repository.put(CommandName.ADD_NEWS, new AddNews());
		repository.put(CommandName.FIND_BY_TITLE, new FindByTitle());
		repository.put(CommandName.FIND_BY_CATEGORY, new FindByCategory());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		
		commandName = CommandName.valueOf((name.toUpperCase()));
		command = repository.get(commandName);

		return command;
	}
}
