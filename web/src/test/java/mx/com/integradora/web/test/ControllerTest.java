package mx.com.integradora.web.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"mx.com.integradora.service", "mx.com.integradora.web.controller"})
@EntityScan("mx.com.integradora.model.entity")
@EnableJpaRepositories("mx.com.integradora.dao")
public class ControllerTest {

	public static void main(String[] args) {
		SpringApplication.run(ControllerTest.class, args);
	}

}
