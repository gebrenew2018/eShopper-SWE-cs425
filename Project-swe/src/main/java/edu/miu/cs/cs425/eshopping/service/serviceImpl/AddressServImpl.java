package edu.miu.cs.cs425.eshopping.service.serviceImpl;

import edu.miu.cs.cs425.eshopping.model.Address;
import edu.miu.cs.cs425.eshopping.repository.IAddressRepo;
import edu.miu.cs.cs425.eshopping.service.IAddressServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServImpl implements IAddressServ {
    private IAddressRepo addressRepo;

    @Autowired
    public AddressServImpl(IAddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public Address getAddress(long id) {
        return null;
    }

    @Override
    public void deleteAddress(long id) {

    }

    @Override
    public Optional<Address> findAddressById(long id) {
        return addressRepo.findById(id);
    }
}
