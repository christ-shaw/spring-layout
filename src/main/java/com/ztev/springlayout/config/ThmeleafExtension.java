package com.ztev.springlayout.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

import javax.annotation.PostConstruct;

@Configuration
public class ThmeleafExtension {

    @Autowired
    private SpringTemplateEngine templateEngine;

    @PostConstruct
    public void extension() {
        UrlTemplateResolver resolver = new UrlTemplateResolver();
        templateEngine.addTemplateResolver(resolver);
    }
}