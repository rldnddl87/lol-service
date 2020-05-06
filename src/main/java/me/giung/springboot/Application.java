package me.giung.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

	private static final String APPLICATION_CONFIG = "spring.config.location=" + "classpath:application.yml,"
			+ "/app/config/app-config.yml";

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).properties(APPLICATION_CONFIG).run(args);

	}

}
