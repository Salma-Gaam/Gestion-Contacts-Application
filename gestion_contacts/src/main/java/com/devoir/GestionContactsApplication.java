package com.devoir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Bean;

import com.devoir.core.services.GroupeServiceImpl;
import com.devoir.core.services.IGroupeService;

@SpringBootApplication
@EntityScan("com.devoir.core.bo")
@EnableJpaRepositories("com.devoir.core.dao")
@ComponentScan("com.devoir.core.web")
@ComponentScan({"com.devoir.core.services.IContactService","com.devoir.core.services.IGroupeService",
	"com.devoir.core.services.ContactServiceImpl","com.devoir.core.services.GroupeServiceImpl"})
@EnableAutoConfiguration
public class GestionContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionContactsApplication.class, args);
	}
	
}