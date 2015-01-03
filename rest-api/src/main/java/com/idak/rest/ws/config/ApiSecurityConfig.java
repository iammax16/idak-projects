package com.idak.rest.ws.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.idak.rest.api.security.RestAuthenticationEntryPoint;
import com.idak.rest.api.security.RestAuthenticationFailueHandler;
import com.idak.rest.api.security.RestAuthenticationSuccessHandler;

/**
 * Permet de configurer la sécurité de l'api
 * @author idak
 *
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "com.idak.rest.api.security" })
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
	 
	 @Resource
	 private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	 @Resource
	 private RestAuthenticationSuccessHandler authenticationSuccessHandler;
	 @Resource
	 private RestAuthenticationFailueHandler  authenticationFailureHandler; 
	
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			// config de deux utilisateurs en mémoire
			// Autres sources de données (db, ws, fichier ...) peuvent être utilisés pour l'auhtntification
		  auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		  auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		}
	 
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			 http.csrf().disable()
             // .authenticationProvider(authenticationProvider())
              .exceptionHandling()
              .authenticationEntryPoint(restAuthenticationEntryPoint); //Pour ne pas rediriger vers un formulaire d'authentification
			 
		  http.authorizeRequests()  
				.antMatchers("/api/admin/**").access("hasRole('ROLE_ADMIN')") //Urls accessibles avec le rôle administrateur 
				.antMatchers("/api/**").access("isAuthenticated()") //Urls de récupération des données. Accessibles si l'utilisateur est connecté
			.and()
				.formLogin()
				.usernameParameter("username") //Renomer le champ j_username par défaut
				.passwordParameter("password") // Renomer le champ j_password par défaut
				.loginProcessingUrl("/auth")   // Renomer l'url d'authentification (par défaut /j_spring_security_check)
				.successHandler(authenticationSuccessHandler) // Redirige vers une service qui modifie la réponse par défaut en cas de succès
				.failureHandler(authenticationFailureHandler) // Redirige vers une service qui modifie la réponse par défaut en cas d'échec
			;
	 
		}
		
		
   
}

