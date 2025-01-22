package com.example.SecurityGuide;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpRequest) throws Exception {
    httpRequest
            .authorizeHttpRequests(myRules -> myRules
              .requestMatchers("/", "/home", "/css/**").permitAll() // says any http requests that match are permited by all
              .anyRequest().authenticated() // all other http requests are authenticated
            )
            .formLogin(myRules -> myRules
                    .loginPage("/login") // which url endpoint to go for a log in
                    .permitAll()
            )
            .logout(myRules -> myRules.permitAll());

    return httpRequest.build();

  }

  @Bean
  public UserDetailsService myService () {
    UserDetails myDetails = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
    return new InMemoryUserDetailsManager(myDetails);
  }

}
