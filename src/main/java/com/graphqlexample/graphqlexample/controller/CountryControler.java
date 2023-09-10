package com.graphqlexample.graphqlexample.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphqlexample.graphqlexample.Modal.CountryEntity;
import com.graphqlexample.graphqlexample.Modal.dto.CountryDto;
import com.graphqlexample.graphqlexample.mappers.Mapper;
import com.graphqlexample.graphqlexample.services.impl.CountryServiceiml;

@RestController
@RequestMapping(value = { "/weather/country", "/weather/country/" })
public class CountryControler {

    private CountryServiceiml countryServices;
    private Mapper<CountryEntity, CountryDto> countryMapper;

    public CountryControler(CountryServiceiml countryServices, Mapper<CountryEntity, CountryDto> countryMapper) {
        this.countryServices = countryServices;
        this.countryMapper = countryMapper;
    }

    
    @CacheEvict(value = "countries", allEntries = true)
    @PostMapping("{id}")
    public ResponseEntity<Object> createCountry(@PathVariable("id") Long id, @RequestBody CountryDto country) {
        if (country.getCountry() == null || country.getCountry().isEmpty()) {
            String errorMessage = "Please provide a valid 'country' value in the request body.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);

        }

        CountryEntity countryEntity = countryMapper.mapFrom(country);
        CountryEntity savedCountryEntity = countryServices.createCountry(id, countryEntity);
        CountryDto responseCountryDto = countryMapper.mapTo(savedCountryEntity);
        return ResponseEntity.ok(responseCountryDto);
    }

    @Cacheable("countries")
    @GetMapping("")
    public List<CountryDto> listAllCountries() {
        List<CountryEntity> countries = countryServices.findAll();
        return countries.stream().map(countryMapper::mapTo).collect(Collectors.toList());
    }
}
