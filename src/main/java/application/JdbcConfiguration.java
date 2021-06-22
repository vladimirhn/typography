package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

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
}
