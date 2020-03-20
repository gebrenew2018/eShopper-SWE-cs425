package edu.miu.cs.cs425.eshopping.service;
import edu.miu.cs.cs425.eshopping.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerServ {
    public abstract Customer addCustomer(Customer customer);
    public abstract Optional<Customer> getCustomer(long id);
    public abstract void deleteCustomer(Customer customer);
    public abstract List<Customer> getAllCustomers();

}
