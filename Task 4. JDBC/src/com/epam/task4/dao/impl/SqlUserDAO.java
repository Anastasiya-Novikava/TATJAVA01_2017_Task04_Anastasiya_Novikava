package com.epam.task4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.task4.bean.Request;
import com.epam.task4.dao.UserDAO;
import com.epam.task4.dao.connectionpool.ConnectionPool;
import com.epam.task4.dao.connectionpool.ConnectionPoolException;
import com.epam.task4.dao.exception.DAOException;

public class SqlUserDAO implements UserDAO {
	private ConnectionPool pool = ConnectionPool.getInstance();

	private final String nameDB = "user";

	private final String INSERT_LOGIN_PASSWORD = "INSERT INTO " + nameDB + " (login, password) VALUES (?, ?)";
	private final String SELECT_LOGIN_PASSWORD = "SELECT * FROM " + nameDB + " WHERE login = ? AND password = ?";
	private final String DELETE_LOGIN = "DELETE FROM " + nameDB + " WHERE login = ?";

	@Override
	public void init() throws DAOException {
		try {
			pool.initPoolData();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void registration(Request request) throws DAOException {
		if (request == null || request.getLogin() == null || request.getPassword() == null) {
			throw new DAOException("Incorrect user initialization");
		}

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = pool.takeConnection();
			preparedStatement = connection.prepareStatement(INSERT_LOGIN_PASSWORD);
			preparedStatement.setString(1, request.getLogin());
			preparedStatement.setString(2, request.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("SQL exception during executing request", e);
		} catch (ConnectionPoolException e2) {
			throw new DAOException("Exception in connection pool", e2);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean signIn(Request request) throws DAOException {
		boolean result = false;
		if (request == null || request.getLogin() == null || request.getPassword() == null) {
			throw new DAOException("Incorrect user initialization");
		}
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = pool.takeConnection();
			preparedStatement = connection.prepareStatement(SELECT_LOGIN_PASSWORD);
			preparedStatement.setString(1, request.getLogin());
			preparedStatement.setString(2, request.getPassword());
			resultSet = preparedStatement.executeQuery();

			resultSet.last();
			if (resultSet.getRow() == 1) {
				result = true;
			}

		} catch (SQLException e) {
			throw new DAOException("SQL exception during executing request", e);
		} catch (ConnectionPoolException e2) {
			throw new DAOException("Exception in connection pool", e2);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public boolean signOut(Request request) throws DAOException {
		boolean result = false;
		if (request == null || request.getLogin() == null) {
			throw new DAOException("Incorrect login initialization");
		}

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = pool.takeConnection();
			
			preparedStatement = connection.prepareStatement(DELETE_LOGIN);
			preparedStatement.setString(1, request.getLogin());
			int countRows = preparedStatement.executeUpdate();
			
			if(countRows != 0){
				result = true;
			}
		} catch (SQLException e) {
			throw new DAOException("SQL exception during executing request", e);
		} catch (ConnectionPoolException e2) {
			throw new DAOException("Exception in connection pool", e2);
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	@Override
	public void destroy() {
		pool.dispose();
	}

}
