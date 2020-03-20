package edu.miu.cs.cs425.eshopping.service;

import edu.miu.cs.cs425.eshopping.model.Payment;

import java.util.List;
import java.util.Optional;

public interface IPaymentServ {
    public abstract Payment addPayment(Payment payment);
    public abstract Optional<Payment> getPayment(long id);
    public abstract List<Payment> getAllPayments();
}
