package com.example.pisio.incidentreportingsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.multipart.MultipartResolver;

@SpringBootApplication
public class IncidentReportingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncidentReportingSystemApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper()
    {
        return  new ModelMapper();
    }

}
