package com.example.projetoRestaurante.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MyWEbSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private FuncionarioDetailsService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/apirest/**")
		.and()
		.authorizeRequests()
			.antMatchers("/apirest/**").hasRole("ADMIN")
			.antMatchers("/vendedores/**").hasAnyRole("ADMIN", "FUNC")
			.antMatchers("/vendedores/vendedor/**").hasAnyRole("ADMIN", "FUNC")
			.antMatchers("/estoques/estoque/**").hasAnyRole("ADMIN", "FUNC")
			.antMatchers("/gerentes/**").hasAnyRole("ADMIN", "FUNC")
			.antMatchers("/gerentes/gerente/**").hasAnyRole("ADMIN")
			.and()
			.httpBasic()
			.and()
			.formLogin()
			.usernameParameter("usuário");
			
	}
	
	
	

}
