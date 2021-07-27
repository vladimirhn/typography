package application;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"application","domain","rest"})
public class Typography {

    static {
//        System.setProperty("log4j.configurationFile", "logger.xml");
    }

    public static void main(String[] args) {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        Logger logger = LogManager.getLogger(Typography.class);
        logger.debug("Try again");

        System.setErr(IoBuilder.forLogger(LogManager.getLogger("consoleErr")).setLevel(Level.ERROR).buildPrintStream());
        System.setOut(IoBuilder.forLogger(LogManager.getLogger("consoleOut")).setLevel(Level.DEBUG).buildPrintStream());

        SpringApplication.run(Typography.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
