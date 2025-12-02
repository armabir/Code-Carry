package com.example.hibernatejpa;

import com.example.hibernatejpa.model.Phone;
import com.example.hibernatejpa.service.PhoneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhoneTest {
    @Autowired
    PhoneService service;

    @Test
    public void testing(){
        Phone phone = new Phone();
//        phone.setId(1);
        phone.setBrand("iPhone");
        phone.setName("New");

        service.save(phone);

    }
}
