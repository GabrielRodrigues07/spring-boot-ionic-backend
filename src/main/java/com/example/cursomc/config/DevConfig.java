package com.example.cursomc.config;

import com.example.cursomc.services.DBService;
import com.example.cursomc.services.EmailService;
import com.example.cursomc.services.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String valor;

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {

        if (!"create".equals(valor)) {
            return false;
        }
        dbService.instantiateTestDatabase();
        return true;
    }

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}