package com.example.SecurityGuide;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {



  public void addViewControllers(ViewControllerRegistry myRegistry) {
    myRegistry.addViewController("/home").setViewName("home");
    myRegistry.addViewController("/").setViewName("home");
    myRegistry.addViewController("/hello").setViewName("hello");
    myRegistry.addViewController("/login").setViewName("login");
  }

}
