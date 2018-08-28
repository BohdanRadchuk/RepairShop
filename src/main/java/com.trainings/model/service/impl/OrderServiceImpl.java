package com.trainings.model.service.impl;

import com.trainings.model.dao.OrderDao;
import com.trainings.model.dto.ManagerOrderDTO;
import com.trainings.model.dto.UserOrderDTO;
import com.trainings.model.entity.Order;
import com.trainings.model.service.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {


    @Override
    public List<UserOrderDTO> findAllUsersOrders(int idUser) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findUsersOrders(idUser);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<ManagerOrderDTO> findNewOrders() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findNewCutOrders();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean createNewOrder(Order order) {

        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.create(order);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Order> findOrderById(int id) {
        Optional<Order> order = Optional.empty();
        try (OrderDao dao = daoFactory.createOrderDao()) {
            order = dao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            dao.update(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
