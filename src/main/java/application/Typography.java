package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"application", "jwtsecurity", "domain", "rest"})
public class Typography {

    static {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Typography.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST")
                        .allowedHeaders("*")
                        .exposedHeaders("content-type")
                        .allowCredentials(true).maxAge(3600);
            }
        };
    }
}
