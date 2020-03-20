package edu.miu.cs.cs425.eshopping.service.serviceImpl;

import edu.miu.cs.cs425.eshopping.model.Order;
import edu.miu.cs.cs425.eshopping.repository.IOrderRepo;
import edu.miu.cs.cs425.eshopping.service.IOrderServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServImpl implements IOrderServ {
    private IOrderRepo orderRepo;

    @Autowired
    public OrderServImpl(IOrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public Optional<Order> getOrder(long id) {
        return orderRepo.findById(id);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepo.deleteById(id);

    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
