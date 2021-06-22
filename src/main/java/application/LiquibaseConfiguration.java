package application;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfiguration {

    @Autowired
    DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase()  {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("liquibase/db-changelog.xml");
        liquibase.setShouldRun(true);
        return liquibase;
    }
}
