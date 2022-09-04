package com.app.phonestore.shop.DTO;

public class ReceivedShop {
    private long id;
    private String name;
    private String address;
    private Integer numOfPhones;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumOfPhones() {
        return numOfPhones;
    }

    public void setNumOfPhones(Integer numOfPhones) {
        this.numOfPhones = numOfPhones;
    }
}
