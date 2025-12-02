package com.example.hibernatejpa.service;

import com.example.hibernatejpa.model.Phone;
import com.example.hibernatejpa.repository.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    private final PhoneRepository repository;

    public PhoneService(PhoneRepository repository){
        this.repository = repository;
    }

    public void save(Phone phone){
        repository.save(phone);
    }

}
