package com.graphqlexample.graphqlexample.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.graphqlexample.graphqlexample.Modal.CountryEntity;

@Service
public interface CountryService {
    CountryEntity createCountry(Long id,CountryEntity country);
    
    List<CountryEntity> findAll();
    
}
