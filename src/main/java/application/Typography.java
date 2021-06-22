package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"application","domain","rest"})
public class Typography {

    public static void main(String[] args) {

        SpringApplication.run(Typography.class, args);
    }
}
