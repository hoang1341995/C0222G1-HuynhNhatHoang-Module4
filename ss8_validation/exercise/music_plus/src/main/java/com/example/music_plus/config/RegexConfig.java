package com.example.music_plus.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class RegexConfig implements WebMvcConfigurer {
    @Bean
    public MessageSource messagesource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("valid/mess_valid");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}