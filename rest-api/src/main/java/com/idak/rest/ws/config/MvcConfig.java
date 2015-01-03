package com.idak.rest.ws.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.idak.rest.api.controller", "com.idak.rest.api.exception" })
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonConverter());
    }

    @Bean
    MappingJackson2HttpMessageConverter jacksonConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
}
