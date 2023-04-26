package com.smec.coupon.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-26  12:46
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean // 注册Bean
    @LoadBalanced // 负载均衡
    public WebClient.Builder register() {
        return WebClient.builder();
    }
}
