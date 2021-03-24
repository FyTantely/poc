package com.poc.api;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.poc.api.donnee.domaine.data.*;
import com.poc.api.service.repository.UserRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.poc.api")
@EnableSwagger2
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class PocApplication {
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}
	
	@PostConstruct
    public void initAll() {

		/*UserAuthentification userAdmin = new UserAuthentification("admin@admin.com","admin",  passwordEncoder.encode("1432"));
        userRepository.save(userAdmin);*/
	}

}
