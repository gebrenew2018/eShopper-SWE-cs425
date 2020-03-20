package edu.miu.cs.cs425.eshopping.service;

import edu.miu.cs.cs425.eshopping.model.Address;

import java.util.Optional;

public interface IAddressServ {
    public abstract Address addAddress(Address address);
    public abstract Address getAddress(long id);
    public abstract void deleteAddress(long id);
    public abstract Optional<Address> findAddressById(long id);
}
