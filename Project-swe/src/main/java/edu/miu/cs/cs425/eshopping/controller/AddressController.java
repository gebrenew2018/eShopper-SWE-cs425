package edu.miu.cs.cs425.eshopping.controller;

import edu.miu.cs.cs425.eshopping.model.Address;
import edu.miu.cs.cs425.eshopping.model.Customer;
import edu.miu.cs.cs425.eshopping.repository.ICustomerRepo;
import edu.miu.cs.cs425.eshopping.service.IAddressServ;
import edu.miu.cs.cs425.eshopping.service.ICustomerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressServ addressServ;
    @Autowired
    private ICustomerServ customerServ;

    @PostMapping(value = "/new/{id}")
    public Address addAddress(@PathVariable long id, @RequestBody Address address) {
        Customer customer = customerServ.getCustomer(id).get();
        return addressServ.addAddress(address);
    }

    @GetMapping(value = "/{id}")
    public Address getAllAddresses(@PathVariable long id) {
        return addressServ.getAddress(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteAddress(@PathVariable long id) {
        addressServ.deleteAddress(id);
    }

    @PutMapping(value = "/edit/{id}")
    public Address updateAddress(@PathVariable long id, @RequestBody Address address) {
        Address result = addressServ.findAddressById(id).orElse(address);
        result.setStreet(address.getStreet());
        result.setCity(address.getCity());
        result.setCountry(address.getCountry());
        result.setZipCode(address.getZipCode());
        result.setPhoneNumber(address.getPhoneNumber());
        Address updated = addressServ.addAddress(result);
        return updated;
    }

    @GetMapping(value = "/list")
    public String getAllAddresses() {
        return "list";
    }

}
