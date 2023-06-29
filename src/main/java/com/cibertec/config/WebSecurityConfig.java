package com.cibertec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	 * throws Exception { http .authorizeHttpRequests((requests) -> requests
	 * .antMatchers("/", "/home").permitAll() .anyRequest().authenticated() )
	 * .formLogin((form) -> form .loginPage("/login") .permitAll() )
	 * .logout((logout) -> logout.permitAll());
	 * 
	 * return http.build(); }
	 */
	@Autowired	
	private UserDetailsService userDetailsService;
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());	    
	}
	
	
	/*
	 * @Override public void configure(WebSecurity web) throws Exception { web
	 * .ignoring()
	 * .antMatchers("/angular/cursos","/assets/**","/css/**","/img/**","/js/**",
	 * "/webfonts/**","/api/**","/",
	 * "/home","/cargaHome","/cargaRegistrar","/registrar"); }
	 */
	 
		
		  @Override protected void configure(HttpSecurity http) throws Exception { http
		  .authorizeRequests((requests) -> { try { requests
		  
		  .antMatchers("/angular/cursos","/*","/assets/**","/css/**","/img/**","/js/**","/webfonts/**","/api/**", "/home","/cargaHome","/cargaRegistrar","/registrar").permitAll()
		  .anyRequest().authenticated().and()		  
		  .csrf().disable().cors().disable();
		  
		  }
		  catch (Exception e) { e.printStackTrace(); } } ) 
		  .formLogin((form) -> form
		  .loginPage("/login") .permitAll() ) .logout((logout) -> logout.permitAll());
		  
		  }
		 
}
