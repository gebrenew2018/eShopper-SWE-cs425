package edu.miu.cs.cs425.eshopping.controller;

import edu.miu.cs.cs425.eshopping.model.Items;
import edu.miu.cs.cs425.eshopping.model.Order;
import edu.miu.cs.cs425.eshopping.service.IItemsServ;
import edu.miu.cs.cs425.eshopping.service.IOrderServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderServ orderServ;
    @GetMapping("/list")
    public List<Order> getAllOrder() {
        return orderServ.getAllOrders();
    }

    @PostMapping("/new")
    public Order addOrder(@RequestBody Order order) {
        return orderServ.addOrder(order);
    }

    @PutMapping("/edit/{id}")
    public Order updateOrder(@PathVariable long id, @RequestBody Order order) {
        Order result = orderServ.getOrder(id).orElse(order);
        result.setOrderNumber(order.getOrderNumber());
        Order updated = orderServ.addOrder(result);
        return updated;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable long id) {
//        Order result = orderServ.getOrder(id).get();
        orderServ.deleteOrder(id);
    }

    @GetMapping("/detail/{id}")
    public Order getItem(@PathVariable long id) {
        Order result = orderServ.getOrder(id).get();
        return result;
    }
}
