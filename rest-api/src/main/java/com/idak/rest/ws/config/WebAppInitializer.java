package com.idak.rest.ws.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Classe d'intialisation du context de la webapp. Elle remplace le fichier web.xml
 * @author idak 
 */
public class WebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// Création de 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
       
        //Chargement de la config spring
        rootContext.register(ServiceConfig.class, ApiSecurityConfig.class);
 
        // Configuration du cycle de vie de  l'application context
        container.addListener(new ContextLoaderListener(rootContext));
 
        // Création du dispatcher servlet's de l'api
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        
        //Chargement de la config spring mvc
        dispatcherServlet.register(MvcConfig.class);
             
        // Enregistrement du dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("rest", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}

}
