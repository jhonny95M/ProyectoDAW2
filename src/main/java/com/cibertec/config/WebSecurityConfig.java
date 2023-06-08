package com.cibertec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests((requests) -> {
			try {
				requests
				    .antMatchers("/css/*","/assets/*","/img/*","/js/*","/", "/home","/cargaHome","/cargaRegistrar","/api/user/register-login","/registrar").permitAll()
				    .anyRequest().authenticated().and()
				    .csrf().disable();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        )
        .formLogin((form) -> form
            .loginPage("/login")
            .permitAll()
        )
        .logout((logout) -> logout.permitAll());
	}

	/*
	 * @Bean public UserDetailsService userDetailsService() { UserDetails user =
	 * User.withDefaultPasswordEncoder() .username("user") .password("password")
	 * .roles("USER") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */
}
