package com.epam.task4.controller.command.impl;

import com.epam.task4.bean.Request;
import com.epam.task4.controller.command.Command;

public class WrongRequest implements Command {

	@Override
	public String execute(Request request) {
		return "Wrong request";
	}
}
