package com.example.AuthenticateAPI.security;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:secrets.properties")
public class SecretConfig {

    @Value("${google.client-id}")
    private String googleClientId;

    @Value("${google.client-secret}")
    private String googleClientSecret;

    @Value("${mail.username}")
    private String mailUsername;

    @Value("${mail.password}")
    private String mailPassword;



    // Add getters or use @PostConstruct to verify if values are loaded correctly
    @PostConstruct
    public void displayProperties() {
        System.out.println("Google Client ID: " + googleClientId);
        System.out.println("Google Client Secret: " + googleClientSecret);
        System.out.println("Mail Username: " + mailUsername);
        System.out.println("Mail Password: " + mailPassword);

    }
}
