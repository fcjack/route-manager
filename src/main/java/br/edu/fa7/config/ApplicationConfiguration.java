package br.edu.fa7.config;

import br.edu.fa7.interceptor.DeleteAuditingInterceptor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "br.edu.fa7")
@PropertySource(value = {"classpath:config.properties", "classpath:log4j2.json"}, ignoreResourceNotFound = false)
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MappingJackson2HttpMessageConverter jsonMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    @Bean
    public ObjectMapper configureJacksonSerializationModule() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return objectMapper;
    }
    @Bean
    public ComboPooledDataSource comboPooledDataSource(RouteManagerSettings routeManagerSettings) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class.getCanonicalName());
        dataSource.setJdbcUrl(routeManagerSettings.getDatabaseUrl());
        dataSource.setUser(routeManagerSettings.getDatabaseUser());
        dataSource.setPassword(routeManagerSettings.getDatabasePassword());
        dataSource.setAcquireIncrement(1);
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxPoolSize(50);

        return dataSource;
    }

    @Bean
    public SpringLiquibase springLiquibase(ComboPooledDataSource comboPooledDataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(comboPooledDataSource);
        liquibase.setDefaultSchema("routemanager");
        liquibase.setChangeLog("classpath:migration/changelog-master.xml");
        return liquibase;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(ComboPooledDataSource comboPooledDataSource) throws IOException {
        LocalSessionFactoryBean entityManagerFactoryBean = new LocalSessionFactoryBean();
        entityManagerFactoryBean.setPackagesToScan("br.edu.fa7.domain");
        entityManagerFactoryBean.setDataSource(comboPooledDataSource);

        Properties properties = new Properties();
        properties.put("hibernate.dialect", PostgreSQL9Dialect.class.getCanonicalName());
        properties.put("hibernate.default_schema", "routemanager");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.connection.autoReconnect", true);
        properties.put("hibernate.connection.autocommit", true);
        properties.put("hibernate.connection.release_mode", "after_transaction");

        entityManagerFactoryBean.setHibernateProperties(properties);
        return entityManagerFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
