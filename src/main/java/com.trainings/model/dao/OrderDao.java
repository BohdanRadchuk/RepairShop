package com.trainings.model.dao;

import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;

import java.util.List;

public interface OrderDao extends GenericDAO<Order, Integer> {
    List<UserOrderDTO> findUsersOrders(int idUser);

    List<ManagerOrderDTO> findNewCutOrders();
}
