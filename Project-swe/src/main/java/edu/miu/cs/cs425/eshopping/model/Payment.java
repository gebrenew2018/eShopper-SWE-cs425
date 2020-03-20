package edu.miu.cs.cs425.eshopping.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentId;
    private int billNumer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateIssued;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Payment() {
    }

    public int getBillNumer() {
        return billNumer;
    }

    public void setBillNumer(int billNumer) {
        this.billNumer = billNumer;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }
}
