package com.app.phonestore.shop;

import com.app.phonestore.exceptions.NoDataFoundExceptions;
import com.app.phonestore.exceptions.ResourceNotFoundException;
import com.app.phonestore.phone.DTO.ReceivedPhone;
import com.app.phonestore.phone.Phone;
import com.app.phonestore.shop.DTO.ReceivedShop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ShopService(ShopRepository shopRepository, ModelMapper modelMapper) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
    }

    public Shop getShop(Long id){
        Shop shop= shopRepository.findById(id).orElse(null);
        if (shop==null){
            throw new ResourceNotFoundException("There is shop with the id: "+id);
        }
        return shop;
    }

    public List<Shop> getAllShops(){
        List<Shop> shops= shopRepository.findAll();
        if (shops.isEmpty()){
            throw new NoDataFoundExceptions("there is no shops ");
        }
        return shops;
    }

    public Shop addShop(ReceivedShop receivedShop){
        Shop shop=modelMapper.map(receivedShop,Shop.class);
        return shopRepository.save(shop);
    }


    public Shop updateShop(ReceivedShop receivedShop) {
        Shop shop= shopRepository.findById(receivedShop.getId()).orElse(null);
        if (shop==null){
            shop=modelMapper.map(receivedShop,Shop.class);
            return shopRepository.save(shop);

        }
        modelMapper.map(receivedShop,shop);
        return shopRepository.save(shop);
    }
}
