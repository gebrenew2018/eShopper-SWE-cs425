package edu.miu.cs.cs425.eshopping.service;
import edu.miu.cs.cs425.eshopping.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderServ {
    public abstract Order addOrder(Order order);
    public abstract Optional<Order> getOrder(long id);
    public abstract void deleteOrder(long id);
    public abstract List<Order> getAllOrders();
}
