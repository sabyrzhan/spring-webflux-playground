package kz.sabyrzhan.springwebfluxplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EntityScan("kz.sabyrzhan.springwebfluxplayground.entities")
@EnableR2dbcRepositories
public class SpringWebfluxPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxPlaygroundApplication.class, args);
	}

}
