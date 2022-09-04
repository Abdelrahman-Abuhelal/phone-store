package com.app.phonestore.shop;

import com.app.phonestore.phone.DTO.ReceivedPhone;
import com.app.phonestore.phone.Phone;
import com.app.phonestore.shop.DTO.ReceivedShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shops/{id}")
    public Shop getShop(@PathVariable Long id){
        return shopService.getShop(id);
    }
    @GetMapping("/shops")
    public List<Shop> getAllShops(){
        return shopService.getAllShops();
    }
    @PostMapping("/shops/addshop")
    public Shop addShop(@RequestBody ReceivedShop receivedShop){
        return shopService.addShop(receivedShop);
    }
    @PutMapping("/shops")
    public Shop updateShop(@RequestBody ReceivedShop receivedShop)
    {
        return shopService.updateShop(receivedShop);
    }

}
