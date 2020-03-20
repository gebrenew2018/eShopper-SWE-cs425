package edu.miu.cs.cs425.eshopping.controller;

import edu.miu.cs.cs425.eshopping.model.Address;
import edu.miu.cs.cs425.eshopping.model.Customer;
import edu.miu.cs.cs425.eshopping.repository.ICustomerRepo;
import edu.miu.cs.cs425.eshopping.service.ICustomerServ;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private ICustomerServ customerServ;

    @Autowired
    public CustomerController(ICustomerServ customerServ) {
        this.customerServ = customerServ;
    }

    @GetMapping("/list")
    public List<Customer> getAllCustomers() {
        return customerServ.getAllCustomers();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerServ.addCustomer(customer);
    }

    @PutMapping("/edit/{id}")
    public Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        Customer result = customerServ.getCustomer(id).orElse(customer);
        result.setFirstName(customer.getFirstName());
        result.setLastName(customer.getLastName());
        result.setMiddleName(customer.getMiddleName());
        result.setPhoneNumber(customer.getPhoneNumber());
        result.setPhoneNumber(customer.getPhoneNumber());
        Customer updated = customerServ.addCustomer(result);
        return updated;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable long id) {
        Customer result = customerServ.getCustomer(id).get();
        customerServ.deleteCustomer(result);
    }

    @GetMapping("/detail/{id}")
    public Customer getCustomer(@PathVariable long id) {
        Customer result = customerServ.getCustomer(id).get();
        return result;
    }
}
