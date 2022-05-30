package application;

import kpersistence.v2.modelsMaster.ModelsMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@EnableJdbcRepositories
@ComponentScan({"application", "jwtsecurity", "domain", "rest"})
public class Typography {

    static {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Typography.class, args);
    }

    @Autowired
    AppProperties appProperties;

    @Bean
    public DataSource getDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(appProperties.getDbDriver());
        dataSource.setUrl(appProperties.getDbUrl());
        dataSource.setSchema(appProperties.getDbSchema());
        dataSource.setUsername(appProperties.getDbUser());
        dataSource.setPassword(appProperties.getDbPassword());

        return dataSource;
    }

    @Bean
    public ModelsMaster getModelsMaster() {
        return new ModelsMaster("domain.models");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST")
                        .allowedHeaders("*")
                        .exposedHeaders("content-type")
                        .allowCredentials(true).maxAge(3600);
            }
        };
    }
}
