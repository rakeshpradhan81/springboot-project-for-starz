package com.example.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@Configuration
@ComponentScan("com.example")
public class CommonConfig {

    @Value("${rest.template.timeout}")
    private int restTemplateTimeout;

    @Bean
    @Primary
    public RestTemplate restTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();
        ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(restTemplateTimeout);
        ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(restTemplateTimeout);
        return restTemplate;
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {return new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

}

