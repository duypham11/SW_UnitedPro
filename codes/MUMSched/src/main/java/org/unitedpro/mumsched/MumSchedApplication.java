package org.unitedpro.mumsched;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MumSchedApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		//Persistence.createEntityManagerFactory("org.unitedpro.mumsched");
		SpringApplication.run(MumSchedApplication.class, args);
	}


}
