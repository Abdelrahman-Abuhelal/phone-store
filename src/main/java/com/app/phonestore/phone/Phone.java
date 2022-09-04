package com.app.phonestore.phone;

import com.app.phonestore.customer.Customer;
import com.app.phonestore.shop.Shop;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Phone {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private boolean isAvailable;
    private double price;
    @ManyToOne
    private Shop shop;
    @ManyToOne
    private Customer customer;


}
