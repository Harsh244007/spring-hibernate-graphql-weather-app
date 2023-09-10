package com.graphqlexample.graphqlexample.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.graphqlexample.graphqlexample.Modal.CountryEntity;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity,String> {
    
}
