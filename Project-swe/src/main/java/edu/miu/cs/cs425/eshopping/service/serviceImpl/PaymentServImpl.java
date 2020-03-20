package edu.miu.cs.cs425.eshopping.service.serviceImpl;

import edu.miu.cs.cs425.eshopping.model.Payment;
import edu.miu.cs.cs425.eshopping.repository.IPaymentRepo;
import edu.miu.cs.cs425.eshopping.service.IPaymentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServImpl implements IPaymentServ {
    private IPaymentRepo paymentRepo;

    @Autowired
    public PaymentServImpl(IPaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    @Override
    public Optional<Payment> getPayment(long id) {
        return paymentRepo.findById(id);
    }


    @Override
    public List<Payment> getAllPayments() {
        return null;
    }
}
