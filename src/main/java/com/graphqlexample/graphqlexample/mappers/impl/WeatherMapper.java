package com.graphqlexample.graphqlexample.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.graphqlexample.graphqlexample.Modal.WeatherEntity;
import com.graphqlexample.graphqlexample.Modal.dto.WeatherDto;
import com.graphqlexample.graphqlexample.mappers.Mapper;

@Component
public class WeatherMapper implements Mapper<WeatherEntity, WeatherDto> {

    private ModelMapper modelMapper;

    public WeatherMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public WeatherDto mapTo(WeatherEntity weatherEntity) {
        return modelMapper.map(weatherEntity, WeatherDto.class);
    }

    @Override
    public WeatherEntity mapFrom(WeatherDto weatherDto) {
        return modelMapper.map(weatherDto, WeatherEntity.class);
    }
}
