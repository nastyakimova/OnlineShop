package com.github.nastyakimova.onlineshop.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.github.nastyakimova.onlineshop.entity"})
@EnableJpaRepositories(basePackages = {"com.github.nastyakimova.onlineshop.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(RepositoryConfiguration.class);
    }
}
