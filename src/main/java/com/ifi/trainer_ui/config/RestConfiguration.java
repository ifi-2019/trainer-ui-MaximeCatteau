package com.ifi.trainer_ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestConfiguration {

    @Value("${trainer.service.user.name}")
    private String username;

    @Value("${trainer.service.user.password}")
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bean
    RestTemplate trainerApiRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor(username, password);
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(interceptor);
        restTemplate.setInterceptors(interceptors);
        return restTemplate;

    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
