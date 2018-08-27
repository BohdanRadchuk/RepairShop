package com.trainings.model.dao;

import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;

import java.util.List;

public interface OrderDao extends GenericDAO<Order, Integer> {
    public List<UserOrderDTO> findUsersOrders(int idUser);
}
