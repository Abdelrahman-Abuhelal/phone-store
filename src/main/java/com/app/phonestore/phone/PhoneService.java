package com.app.phonestore.phone;


import com.app.phonestore.customer.DTO.ReceievedCustomer;
import com.app.phonestore.exceptions.NoDataFoundExceptions;
import com.app.phonestore.exceptions.ResourceNotFoundException;
import com.app.phonestore.phone.DTO.ReceivedPhone;
import com.app.phonestore.shop.ShopRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository, ShopRepository shopRepository, ModelMapper modelMapper) {
        this.phoneRepository = phoneRepository;
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
    }

    public Phone getPhone(Long id){
        Phone phone =phoneRepository.findById(id).orElse(null);
        if (phone==null){
            throw new ResourceNotFoundException("Phone is not found for the id ->"+id);
        }
        return phone;

    }

    public List<Phone> getAllPhones(){
        List<Phone> phones= phoneRepository.findAll();
        if (phones.isEmpty()){
            throw new NoDataFoundExceptions("There is no phones");
        }
        return phones;
    }

    public Phone addPhone(ReceivedPhone receivedPhone){
        Phone phone=modelMapper.map(receivedPhone,Phone.class);
        return phoneRepository.save(phone);
    }

    public Phone updatePhone(ReceivedPhone receivedPhone){
       Phone phone= phoneRepository.findById(receivedPhone.getId()).orElse(null);
       if (phone==null){
           phone=modelMapper.map(receivedPhone,Phone.class);
           return phoneRepository.save(phone);

       }
       modelMapper.map(receivedPhone,phone);
       return phoneRepository.save(phone);
    }


}
