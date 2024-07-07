package com.cisco.doctor_schedule_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfig {
    @Bean
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder();
    }
}
