package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
public class AppProperties {

    @Autowired
    private Environment env;

    public String getDbDriver() {
        return env.getProperty("db.driver");
    }

    public String getDbUrl() {
        return env.getProperty("db.url");
    }

    public String getDbSchema() {
        return env.getProperty("db.schema");
    }

    public String getDbUser() {
        return env.getProperty("db.user");
    }

    public String getDbPassword() {
        return env.getProperty("db.password");
    }
}
