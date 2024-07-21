package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "application/entity")
@EnableJpaRepositories(basePackages = "service")
public class ControleGastosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ControleGastosApplication.class, args);
    }
}