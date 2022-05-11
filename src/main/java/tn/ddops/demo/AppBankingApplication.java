package tn.ddops.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan
@EnableJpaRepositories
@EntityScan("tn.ddops.demo.entities")
@SpringBootApplication
public class AppBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBankingApplication.class, args);
	}

}
