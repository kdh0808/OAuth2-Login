package com.koreait.oauth2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.formLogin().loginPage("/login").permitAll()
                    .and()
                .oauth2Login().loginPage("/login").permitAll()
                    .and()
                .authorizeRequests().anyRequest().authenticated();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //정적 자원들을 스프링 시큐리티 적용에서 제외시키겠다
    //예) /css/style.css 호출시
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (webSecurity) -> webSecurity.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

}
