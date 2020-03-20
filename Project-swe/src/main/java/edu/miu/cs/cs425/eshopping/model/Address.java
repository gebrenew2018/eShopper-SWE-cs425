package edu.miu.cs.cs425.eshopping.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;
    @NotNull(message = "Street is required")
    private String street;
    @NotNull(message = "ZipCode is required")
    private String zipCode;
    @NotNull(message = "city is required")
    private String city;
    @NotNull(message = "country is required")
    private String country;
    private String phoneNumber;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Address() {
    }

    public Address(String street,String zipCode, String country, String city,String phoneNumber) {
        this.street=street;
        this.city=city;
        this.country=country;
        this.phoneNumber=phoneNumber;
        this.zipCode=zipCode;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String  getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String  phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
