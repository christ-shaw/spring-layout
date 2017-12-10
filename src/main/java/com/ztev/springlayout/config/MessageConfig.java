git//package com.ztev.springlayout.config;
//
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//
//public class MessageConfig extends WebMvcConfigurerAdapter {
//
//    @Bean(name = "messageSource")
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:message/messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setDefaultEncoding("zh_CN");
//        messageSource.setFallbackToSystemLocale(true);
//        return messageSource;
//    }
//
//}