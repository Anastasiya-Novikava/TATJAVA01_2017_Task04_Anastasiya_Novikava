package com.epam.task4.dao.factory;

import com.epam.task4.dao.NewsDAO;
import com.epam.task4.dao.UserDAO;
import com.epam.task4.dao.impl.SqlNewsDAO;
import com.epam.task4.dao.impl.SqlUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final NewsDAO sqlNewsImpl = new SqlNewsDAO();
    private final UserDAO sqlUserImpl = new SqlUserDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public NewsDAO getNewsDAO(){
        return sqlNewsImpl;
    }
    
    public UserDAO getUserDAO(){
        return sqlUserImpl;
    }
}