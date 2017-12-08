package com.ztev.springlayout.config;

/**
 * Created by ${xiaozb} on 2017/12/8.
 *
 * @copyright by ztev
 */

import com.ztev.springlayout.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountService accountService;
    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.eraseCredentials(true).
                userDetailsService(accountService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().antMatchers("/","/favicon","/resources/**","/sign-up").permitAll()
                .and()
                .formLogin().loginPage("/sign-in").permitAll().failureUrl("/login?error=1").loginProcessingUrl("/authenticate")
                .and().
                logout().
                 logoutUrl("/logout")
                .permitAll()
                .logoutSuccessUrl("/signin?logout")
                .and();
//                .rememberMe()
//                .rememberMeServices(rememberMeServices())
//                .key("remember-me-key");
    }
}