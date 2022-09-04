package com.app.phonestore.phone.DTO;

public class ReceivedPhone {
    private long id;
    private String name;
    private String description;
    private boolean isAvailable;
    private double price;
    private Long shopId;
//    private Long customerId;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
//
//    public Long getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Long customerId) {
//        this.customerId = customerId;
//    }
//
//    public Long getShopId() {
//        return shopId;
//    }
//
//    public void setShopId(Long shopId) {
//        this.shopId = shopId;
//    }
}
