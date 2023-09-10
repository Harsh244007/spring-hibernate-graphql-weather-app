package com.graphqlexample.graphqlexample.services;

import java.util.List;

import com.graphqlexample.graphqlexample.Modal.WeatherEntity;

public interface WeatherServices {
    WeatherEntity createWeather(WeatherEntity weather);

    List<WeatherEntity> findAll();
}
