package com.app.phonestore.customer;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String contactNum;


}
