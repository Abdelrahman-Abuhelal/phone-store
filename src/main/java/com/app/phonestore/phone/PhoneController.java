package com.app.phonestore.phone;

import com.app.phonestore.phone.DTO.ReceivedPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/phones/{id}")
    public Phone getPhone(@PathVariable Long id){
        return phoneService.getPhone(id);
    }

    @GetMapping("/phones")
    public List<Phone> getAllPhones(){
        return phoneService.getAllPhones();
    }

    @PostMapping("/phones/addphone")
    public Phone addPhone(@RequestBody ReceivedPhone receivedPhone){
        return phoneService.addPhone(receivedPhone);
    }

    @PutMapping("/phones")
    public Phone updatePhone(@RequestBody ReceivedPhone receivedPhone)
    {
        return phoneService.updatePhone(receivedPhone);
    }


}
