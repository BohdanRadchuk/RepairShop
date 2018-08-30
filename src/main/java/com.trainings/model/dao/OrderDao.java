package com.trainings.model.dao;

import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderDao extends GenericDao<Order, Integer> {
    List<UserOrderDTO> findUsersOrders(int idUser);
    List<ManagerOrderDTO> findNewCutOrders();
    List<Order> findConfirmInWorkMasterOrders(int idMaster);

    void archiveOldDoneRecords(LocalDateTime localDateTime);
}
