package com.trainings.model.service;

import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService extends Service{
    List<UserOrderDTO> findAllUsersOrders(int idUser);
    List<ManagerOrderDTO> findNewOrders ();
    boolean createNewOrder (Order order);
    Optional<Order> findOrderById (int id);
    void updateOrder (Order order);
}
