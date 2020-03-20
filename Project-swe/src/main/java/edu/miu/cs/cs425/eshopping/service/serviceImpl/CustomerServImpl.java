package edu.miu.cs.cs425.eshopping.service.serviceImpl;

import edu.miu.cs.cs425.eshopping.model.Customer;
import edu.miu.cs.cs425.eshopping.repository.IAddressRepo;
import edu.miu.cs.cs425.eshopping.repository.ICustomerRepo;
import edu.miu.cs.cs425.eshopping.service.ICustomerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServImpl implements ICustomerServ {
    private ICustomerRepo customerRepo;

    @Autowired
    public CustomerServImpl(ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Optional<Customer> getCustomer(long id) {
        return customerRepo.findById(id);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepo.delete(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
