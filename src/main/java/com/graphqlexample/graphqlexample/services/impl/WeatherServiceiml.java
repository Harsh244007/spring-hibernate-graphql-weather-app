package com.graphqlexample.graphqlexample.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.graphqlexample.graphqlexample.Modal.WeatherEntity;
import com.graphqlexample.graphqlexample.respositories.WeatherRepositories;
import com.graphqlexample.graphqlexample.services.WeatherServices;

// import graphql.kickstart.tools.GraphQLMutationResolver;
// import graphql.kickstart.tools.GraphQLQueryResolver;

@Service
public class WeatherServiceiml implements WeatherServices {
    
    private WeatherRepositories weatherRepositories;

    public WeatherServiceiml(WeatherRepositories weatherRepositories) {
        this.weatherRepositories = weatherRepositories;
    }

    @Override
    public WeatherEntity createWeather(WeatherEntity weatherEntity){
        return weatherRepositories.save(weatherEntity);
    }

    @Override
    public List<WeatherEntity> findAll() {
        return StreamSupport.stream(weatherRepositories.findAll().spliterator(), false).collect(Collectors.toList());
    }
    
}
