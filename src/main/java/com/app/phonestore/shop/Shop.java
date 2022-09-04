package com.app.phonestore.shop;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data

public class Shop {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private Integer numOfPhones;

}
