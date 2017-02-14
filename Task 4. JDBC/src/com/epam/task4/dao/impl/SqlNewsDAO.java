package com.epam.task4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import com.epam.task4.bean.Category;
import com.epam.task4.bean.News;
import com.epam.task4.bean.Request;
import com.epam.task4.dao.NewsDAO;
import com.epam.task4.dao.connectionpool.ConnectionPool;
import com.epam.task4.dao.connectionpool.ConnectionPoolException;
import com.epam.task4.dao.exception.DAOException;

public class SqlNewsDAO implements NewsDAO {
	private ConnectionPool pool = ConnectionPool.getInstance();

	private final String nameDB = "news";

	private final String INSERT_QUERY = "INSERT INTO " + nameDB + " (title, category, content) VALUES (?, ?, ?)";
	private final String SELECT_TITLE_QUERY = "SELECT * FROM " + nameDB + " WHERE title = ?";
	private final String SELECT_CATEGORY_QUERY = "SELECT * FROM " + nameDB + " WHERE category = ?";

	@Override
	public void init() throws DAOException {
		try {
			pool.initPoolData();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void addNews(Request request) throws DAOException {
		if (request == null || request.getTitle() == null || request.getCategory() == null
				|| request.getContent() == null) {
			throw new DAOException("Incorrect news initialization");
		}

		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try {
			connection = pool.takeConnection();
			preparedStatement = connection.prepareStatement(INSERT_QUERY);
			preparedStatement.setString(1, request.getTitle());
			preparedStatement.setString(2, request.getCategory().name().toLowerCase());
			preparedStatement.setString(3, request.getContent());
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
	public HashSet<News> findByTitle(Request request) throws DAOException {
		if (request == null || request.getTitle() == null) {
			throw new DAOException("Incorrect title initialization");
		}

		HashSet<News> result = new HashSet<>();
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = pool.takeConnection();
			preparedStatement = connection.prepareStatement(SELECT_TITLE_QUERY);
			preparedStatement.setString(1, request.getTitle());
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String title = resultSet.getString(2);
				String category = resultSet.getString(3);
				String content = resultSet.getString(4);
				News news = new News(title, Category.valueOf(category.toUpperCase()), content);
				result.add(news);
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
	public HashSet<News> findByCategory(Request request) throws DAOException {
		if (request == null || request.getCategory() == null) {
			throw new DAOException("Incorrect category initialization");
		}

		HashSet<News> result = new HashSet<>();
		
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = pool.takeConnection();
			preparedStatement = connection.prepareStatement(SELECT_CATEGORY_QUERY);
			preparedStatement.setString(1, request.getCategory().name().toLowerCase());
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String title = resultSet.getString(2);
				String category = resultSet.getString(3);
				String content = resultSet.getString(4);
				News news = new News(title, Category.valueOf(category.toUpperCase()), content);
				result.add(news);
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
	public void destroy() {
		pool.dispose();
	}
}
