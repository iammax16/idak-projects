package fr.idak.tutorial.ws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"fr.idak.tutorial.ws.web"})
public class WebMvcConfig  extends WebMvcConfigurerAdapter{
	
}
