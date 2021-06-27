package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableJdbcRepositories
public class JdbcConfiguration extends AbstractJdbcConfiguration {

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

// Скорее всего не нужен, вроде загружается автоматически
//    @Bean
//    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
//        return new NamedParameterJdbcTemplate(dataSource);
//    }

}
