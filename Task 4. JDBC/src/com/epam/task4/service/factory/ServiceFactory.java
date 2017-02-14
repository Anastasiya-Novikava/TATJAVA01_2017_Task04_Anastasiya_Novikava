package com.epam.task4.service.factory;

import com.epam.task4.service.CatalogService;
import com.epam.task4.service.ClientService;
import com.epam.task4.service.impl.CatalogServiceImpl;
import com.epam.task4.service.impl.ClientServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ClientService clientService = new ClientServiceImpl();
    private final CatalogService catalogService = new CatalogServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public ClientService getClientService(){
        return clientService;
    }
    
    public CatalogService getCatalogService(){
        return catalogService;
    }
}