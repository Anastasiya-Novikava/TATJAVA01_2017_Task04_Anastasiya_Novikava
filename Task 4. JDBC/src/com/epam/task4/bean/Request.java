package com.epam.task4.bean;

import java.io.Serializable;

import com.epam.task4.controller.command.CommandName;

public class Request implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private CommandName commandName;
	private String title;
	private Category category;
	private String content;
	private String login;
	private String password;
	
	public Request() {}
	
	public CommandName getCommandName() {
        return commandName;
    }
	
	public void setCommand(CommandName name) {
        this.commandName = name;
    }
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Request request = (Request) obj;
	
		if (null == commandName) {
			return (commandName == request.commandName);
		} else {
			if (!commandName.equals(request.commandName)) {
				return false;
			}
		}
		
		if (null == title) {
			return (title == request.title);
		} else {
			if (!title.equals(request.title)) {
				return false;
			}
		}

		if (null == category) {
			return (category == request.category);
		} else {
			if (!category.equals(request.category)) {
				return false;
			}
		}

		if (null == content) {
			return (content == request.content);
		} else {
			if (!content.equals(request.content)) {
				return false;
			}
		}

		if (null == login) {
			return (login == request.login);
		} else {
			if (!login.equals(request.login)) {
				return false;
			}
		}

		if (null == password) {
			return (password == request.password);
		} else {
			if (!password.equals(request.password)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = commandName == null ? 0 : commandName.hashCode();
		result = 31 * result + (title == null ? 0 : title.hashCode());
		result = 31 * result + (category == null ? 0 : category.hashCode());
		result = 31 * result + (content == null ? 0 : content.hashCode());
		result = 31 * result + (login == null ? 0 : login.hashCode());
		result = 31 * result + (password == null ? 0 : password.hashCode());

		return result;
	}

	@Override
	public String toString() {
		return "commandName = " + commandName + ", title = " + title + ", category = " + category + ", content = " + content + ", login = " + login + ", password = " + password +"\n";
	}
}
