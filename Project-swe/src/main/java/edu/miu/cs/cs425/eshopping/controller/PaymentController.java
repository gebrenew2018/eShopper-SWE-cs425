package edu.miu.cs.cs425.eshopping.controller;

import edu.miu.cs.cs425.eshopping.model.Items;
import edu.miu.cs.cs425.eshopping.model.Payment;
import edu.miu.cs.cs425.eshopping.service.IItemsServ;
import edu.miu.cs.cs425.eshopping.service.IPaymentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private IPaymentServ paymentServ;
    @GetMapping("/list")
    public List<Payment> getAllPayments() {
        return paymentServ.getAllPayments();
    }

    @PostMapping("/new")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentServ.addPayment(payment);
    }

    @GetMapping("/detail/{id}")
    public Optional<Payment> getPayment(@PathVariable long id) {
        Optional<Payment> result = paymentServ.getPayment(id);
        return result;
    }
}
