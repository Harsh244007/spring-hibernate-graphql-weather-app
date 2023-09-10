package com.graphqlexample.graphqlexample.respositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.graphqlexample.graphqlexample.Modal.WeatherEntity;

@Repository
public interface WeatherRepositories extends CrudRepository<WeatherEntity,String> {
    
}
