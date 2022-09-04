package com.app.phonestore.conf;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class ConfigBeans {

    @Bean
    public ModelMapper modelMapper() {
        Converter<String, Date> toStringDate = new AbstractConverter<String, Date>() {
            @Override
            protected Date convert(String source) {
                Date date;
                try {
                    date = new SimpleDateFormat("dd-MM-yyyy").parse(source);
                } catch (ParseException e) {
                    date = new Date();
                }
                return date;
            }
        };
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(String.class, Date.class);
        modelMapper.addConverter(toStringDate);
        return modelMapper;
    }
}
