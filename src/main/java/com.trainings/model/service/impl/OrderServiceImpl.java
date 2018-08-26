package com.trainings.model.service.impl;

import com.trainings.model.dao.OrderDao;
import com.trainings.model.entity.Order;
import com.trainings.model.service.OrderService;

public class OrderServiceImpl implements OrderService {
    OrderDao dao = daoFactory.createOrderDao();

    @Override
    public boolean createNewOrder(Order order) {

        return dao.create(order);
    }
}
