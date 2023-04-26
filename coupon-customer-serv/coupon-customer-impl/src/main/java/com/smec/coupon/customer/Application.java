package com.smec.coupon.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author 魏启恒
 * @Description //TODO
 * @Date 2023-04-24  14:07
 */
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.smec"})
@EnableTransactionManagement
//用于扫描Dao @Repository
@EnableJpaRepositories(basePackages = {"com.smec"})
//用于扫描JPA实体类 @Entity，默认扫本包当下路径
@EntityScan(basePackages = {"com.smec"})
@EnableDiscoveryClient
@EnableFeignClients
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
