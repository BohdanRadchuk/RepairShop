package com.trainings.model.service;

import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService extends Service{
    List<UserOrderDTO> findAllUsersOrders(int idUser);
    boolean createNewOrder (Order order);
    Optional<Order> findOrderById (int id);
}
