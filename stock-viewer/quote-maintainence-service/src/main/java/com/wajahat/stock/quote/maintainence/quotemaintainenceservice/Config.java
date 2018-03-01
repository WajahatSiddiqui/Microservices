package com.wajahat.stock.quote.maintainence.quotemaintainenceservice;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * quote-maintainence-service - Configuration
 *
 * @author Wajahat Siddiqui
 */
@Configuration
public class Config {
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
