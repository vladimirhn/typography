package application;

import kcollections.CollectionFactory;
import kcollections.KList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"application", "jwtsecurity", "domain", "rest"})
public class Typography {

    static {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Typography.class, args);

        class Test {
            String name;
            Integer amount;
            String color;

            public Test(String name, Integer amount, String color) {
                this.name = name;
                this.amount = amount;
                this.color = color;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getAmount() {
                return amount;
            }

            public void setAmount(Integer amount) {
                this.amount = amount;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            @Override
            public String toString() {
                return "Test{" +
                        "name='" + name + '\'' +
                        ", amount=" + amount +
                        ", color='" + color + '\'' +
                        '}';
            }
        }

        KList<Test> test = CollectionFactory.makeList(
                new Test("one", 1, "blue"),
                new Test("one", 2, "blue"),
                new Test("two", 3, "red"),
                new Test("two", 3, "blue"),
                new Test("three", 5, "blue"),
                new Test("three", 6, "blue")
        );

        System.out.println(test.distinct(Test::getName, Test::getAmount, Test::getColor));
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
