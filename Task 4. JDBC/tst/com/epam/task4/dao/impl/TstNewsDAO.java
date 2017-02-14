package com.epam.task4.dao.impl;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.task4.bean.Category;
import com.epam.task4.bean.News;
import com.epam.task4.bean.Request;
import com.epam.task4.dao.connectionpool.ConnectionPool;
import com.epam.task4.dao.exception.DAOException;

public class TstNewsDAO {
	SqlNewsDAO newsDAO;

	@BeforeTest
	public void init() throws Exception {
		ConnectionPool.getInstance().initPoolData();
	}

	@BeforeMethod
	public void setUp() {
		newsDAO = new SqlNewsDAO();
	}

	@AfterMethod
	public void setDown() {
		newsDAO = null;
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
	public void tstPositiveAddNews() throws DAOException {
		Request request = new Request();

		request.setTitle("Popular_songs");
		request.setCategory(Category.DISK);
		request.setContent("text_of_newssdfdffdfsfdfdf"); 
		newsDAO.addNews(request);
	}

	@Test
	public void tstPositiveFindByTitle() throws DAOException {
		Request request = new Request();

		request.setTitle("New_song");
		newsDAO.findByTitle(request);
	}

	@Test
	public void tstPositiveFindByCategory() throws DAOException {
		Request request = new Request();

		request.setCategory(Category.FILM);
		newsDAO.findByCategory(request);
	}

	@Test(expectedExceptions = DAOException.class)
	public void tstNegativeAddNews() throws DAOException {
		Request request = new Request();
		News news = new News();

		request.setTitle(news.getTitle());
		request.setCategory(news.getCategory());
		request.setContent(news.getContent());
		newsDAO.addNews(request);
	}
	
	@Test(dataProvider = "Illegal request", expectedExceptions = DAOException.class)
    public void tstNegativefindByTitle(Request request) throws Exception {
        newsDAO.findByTitle(request);
    }
	
	@Test(dataProvider = "Illegal request", expectedExceptions = DAOException.class)
    public void tstNegativefindByCategory(Request request) throws Exception {
        newsDAO.findByCategory(request);
    }
}
