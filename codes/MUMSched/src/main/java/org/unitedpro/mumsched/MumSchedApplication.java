package org.unitedpro.mumsched;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class MumSchedApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {

		SpringApplication.run(MumSchedApplication.class, args);
	}


}
