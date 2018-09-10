package com.trainings.model.dao.impl;

import com.trainings.model.dao.OrderDao;
import com.trainings.model.dao.factory.DaoFactory;
import com.trainings.model.entity.Order;
import com.trainings.model.entity.OrderBuilder;
import com.trainings.model.entity.Status;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JDBCOrderDaoTest {
    private int idServe = 1;
    private int idUser = 6;
    private int lastId;
    private OrderDao orderDao;
    private Order testOrder = new OrderBuilder()
                .setIdServe(idServe)
                .setIdUser(idUser)
                .setStatus(Status.NEW)
                .createOrder();

    @Before
    public void setUp() throws Exception {
        orderDao = DaoFactory.getInstance().createOrderDao();
        //creating element to be sure that index of the next element wold be current id +1
        orderDao.create(testOrder);
        List<Order> orders = orderDao.findAll();
        lastId = orders.get(orders.size()-1).getIdOrder();
    }


    @After
    public void tearDown() throws Exception {
        orderDao.delete(lastId);
    }

    @Test
    public void create() {
        orderDao.create(testOrder);
        testOrder.setIdOrder(lastId + 1);
        List<Order> newOrders = orderDao.findAll();
        Assert.assertEquals(newOrders.get(newOrders.size() - 1), testOrder);
        orderDao.delete(lastId + 1);

    }

    @Test
    public void findById() {
        int nextIdToFind = lastId + 1;
        Assert.assertFalse(orderDao.findById(nextIdToFind).isPresent());
        orderDao.create(testOrder);
        testOrder.setIdOrder(nextIdToFind);
        Assert.assertEquals(testOrder, orderDao.findById(nextIdToFind).get());
        orderDao.delete(nextIdToFind);
    }

    @Test
    public void findAll() {
        List<Order> orders = orderDao.findAll();
        int sizeAllTable = orders.size();
        orderDao.create(testOrder);
        testOrder.setIdOrder(lastId+1);
        List<Order> ordersNew = orderDao.findAll();
        Assert.assertEquals(ordersNew.size(), sizeAllTable + 1);
        Assert.assertEquals(ordersNew.get(ordersNew.size() - 1), testOrder);
        orderDao.delete(lastId);
        orderDao.delete(lastId-1);
    }

    @Test
    public void update() {
        int id = lastId+1;
        orderDao.create(testOrder);
        testOrder.setIdOrder(id);
        testOrder.setStatus(Status.CONFIRM);
        testOrder.setIdManager(3);
        orderDao.update(testOrder);
        Assert.assertEquals(testOrder.getStatus(), orderDao.findById(id).get().getStatus());
        Assert.assertEquals(testOrder, orderDao.findById(id).get());
    }

    @Test
    public void delete() {
        orderDao.create(testOrder);
        List<Order> orders = orderDao.findAll();

        boolean deleted = orderDao.delete(orders.get(orders.size()-1).getIdOrder());

        Assert.assertTrue(deleted);
        Assert.assertTrue((orders.size() - orderDao.findAll().size()) == 1);
        Assert.assertFalse(orderDao.findById(orders.get(orders.size()-1).getIdOrder()).isPresent());

    }


}