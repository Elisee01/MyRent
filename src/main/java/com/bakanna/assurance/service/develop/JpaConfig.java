package com.bakanna.assurance.service.develop;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EntityScan(basePackages = {"com.bakanna.assurance.service.develop.model"})
@EnableJpaRepositories(basePackages = "com.bakanna.assurance.service.develop.repository")
public class JpaConfig {

    @Primary
    @Bean(name = "jpaSharedEM_dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource jpaSharedEM_dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jpaSharedEM_entityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean jpaSharedEM_entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource jpaSharedEM_dataSource) {
        return builder
                .dataSource(jpaSharedEM_dataSource)
                .packages("com.bakanna.assurance.service.develop.model")
                .persistenceUnit("jpaSharedEM")
                .build();
    }
}

