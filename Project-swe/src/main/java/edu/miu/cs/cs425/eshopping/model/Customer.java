package edu.miu.cs.cs425.eshopping.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    @NotNull(message = "First Name is required")
    private String firstName;
    private String middleName;
    @NotNull(message = "Last Name is required")
    private String lastName;
    private String phoneNumber;
@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "customer")
private Address address;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer")
private List<Order> orderList=new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer")
    private List<Payment> paymentList=new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "customer")
    private ShoppingCart shoppingCart;

    public Customer() {
    }
    public Customer(String firstName,String middleName,String lastName,String phoneNumber ) {
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String  getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String  phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
