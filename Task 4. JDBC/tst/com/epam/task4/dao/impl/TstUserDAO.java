package com.epam.task4.dao.impl;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.task4.bean.Request;
import com.epam.task4.bean.User;
import com.epam.task4.dao.connectionpool.ConnectionPool;
import com.epam.task4.dao.exception.DAOException;

public class TstUserDAO {
	SqlUserDAO userDAO;

	@BeforeTest
	public void init() throws Exception {
		ConnectionPool.getInstance().initPoolData();
	}

	@BeforeMethod
	public void setUp() {
		userDAO = new SqlUserDAO();
	}

	@AfterMethod
	public void setDown() {
		userDAO = null;
	}

	@AfterTest
	public void destroy() {
		ConnectionPool.getInstance().dispose();
	}

	@DataProvider(name = "Illegal request")
    public Object[][] getIllegalRequests() {
        return new Object[][] {
                {new Request()},
                {null}
        };
    }

	@Test
	public void tstPositiveRegistration() throws DAOException {
		Request request = new Request();

		request.setLogin("dog");
		request.setPassword("cat");
		userDAO.registration(request);
	}

	@Test
	public void tstPositiveSignIn() throws DAOException {
		Request request = new Request();

		request.setLogin("lol");
		request.setPassword("lol");
		Assert.assertTrue(userDAO.signIn(request));
	}

	@Test
	public void tstPositiveSignOut() throws DAOException {
		Request request = new Request();

		request.setLogin("hellop");
		Assert.assertTrue(userDAO.signOut(request));
	}

	@Test(expectedExceptions = DAOException.class)
	public void tstNegativeRegistration() throws DAOException {
		Request request = new Request();
		User user = new User();
		
		request.setLogin(user.getLogin());
		request.setPassword(user.getPassword());
		userDAO.registration(request);
	}
	
	@Test(dataProvider = "Illegal request", expectedExceptions = DAOException.class)
    public void tstNegativeSignIn(Request request) throws Exception {
		userDAO.signIn(request);
    }
	
	@Test(dataProvider = "Illegal request", expectedExceptions = DAOException.class)
    public void tstNegativeSignOut(Request request) throws Exception {
		userDAO.signOut(request);
    }
}
