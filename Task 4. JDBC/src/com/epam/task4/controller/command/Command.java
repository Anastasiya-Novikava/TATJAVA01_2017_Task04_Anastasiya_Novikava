package com.epam.task4.controller.command;

import com.epam.task4.bean.Request;

public interface Command {
	public String execute(Request request);
}
