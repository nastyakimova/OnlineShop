package com.github.nastyakimova.onlineshop;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.github.nastyakimova.onlineshop.entity"})
@EnableJpaRepositories(basePackages = {"com.github.nastyakimova.onlineshop.repositories"})
@PropertySource(value = { "classpath:application.properties" })
@EnableTransactionManagement
public class RepositoryConfiguration {
}