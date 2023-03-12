package ru.gb.mark.lesson7.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

    @Bean
    public HttpServletRequest request(HttpServletRequest request) {
        return request;
    }
}
