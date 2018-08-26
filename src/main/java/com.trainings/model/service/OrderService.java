package com.trainings.model.service;

import com.trainings.model.entity.Order;

public interface OrderService extends Service{
    boolean createNewOrder (Order order);
}
