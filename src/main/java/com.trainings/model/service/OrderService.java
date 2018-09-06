package com.trainings.model.service;

import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public interface OrderService extends Service {
    Logger logger = LogManager.getLogger(OrderService.class);

    List<UserOrderDTO> findAllUsersOrders(int idUser);

    List<ManagerOrderDTO> findNewOrders(int currentPage);

    boolean createNewOrder(Order order);

    Optional<Order> findOrderById(int id);

    void updateOrder(Order order);

    List<Order> findConfirmOrders(int id);

    int getNumberOfOrderRows();
}
