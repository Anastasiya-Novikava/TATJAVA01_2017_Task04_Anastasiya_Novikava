package com.epam.task4.bean;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;

	public User() {}

	public User(String login, String password) {
		setLogin(login);
		setPassword(password);
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

		User user = (User) obj;
	
		if (null == login) {
			return (login == user.login);
		} else {
			if (!login.equals(user.login)) {
				return false;
			}
		}
		
		if (null == password) {
			return (password == user.password);
		} else {
			if (!password.equals(user.password)) {
				return false;
			}
		}
		
		return true;
	}

	@Override
    public int hashCode() {
		int result = login == null ? 0 : login.hashCode();
        result = 31 * result + (password == null ? 0 : password.hashCode());

        return result;
    }
	
	@Override
	public String toString() {
		return "login = " + login + ", password = " + password + "\n";
	}

}

