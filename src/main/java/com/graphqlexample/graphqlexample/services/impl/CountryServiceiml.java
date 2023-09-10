package com.graphqlexample.graphqlexample.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.graphqlexample.graphqlexample.Modal.CountryEntity;
import com.graphqlexample.graphqlexample.respositories.CountryRepository;
import com.graphqlexample.graphqlexample.services.CountryService;

@Service
public class CountryServiceiml implements CountryService {
    private CountryRepository countryRepository;

    public CountryServiceiml(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public CountryEntity createCountry(Long id, CountryEntity countryEntity) {
        countryEntity.setId(id);
        return countryRepository.save(countryEntity);

    }

    public List<CountryEntity> findAll() {
        return StreamSupport.stream(countryRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
