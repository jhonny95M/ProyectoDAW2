package com.cibertec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


  @Configuration public class WebConfig implements WebMvcConfigurer {
  
		/*
		 * @Override public void addViewControllers(ViewControllerRegistry registry) {
		 * registry.addViewController("/").setViewName("forward:/app/index.html"); }
		 */
	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	      registry.addResourceHandler("/app/**")
	              .addResourceLocations("classpath:/static/app/");
	  }
	  @Override
	public void addCorsMappings(CorsRegistry registry) {
		  registry.addMapping("/api/**")
          //.allowedOrigins("http://localhost:4200")
		  .allowedOrigins("https://4ceba2b3ca3b-13997195075582013881.ngrok-free.app")
          .allowedMethods("GET", "POST", "PUT", "DELETE")
          .allowedHeaders("*")
          .allowCredentials(true);
	}
  }
 
