package com.idak.rest.ws.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Déclaration de la config de spring sécurity
 * 
 * <p>
 * Equivalent dans le fichier web.xml
 * <filter>
 *		<filter-name>springSecurityFilterChain</filter-name>
 *		<filter-class>org.springframework.web.filter.DelegatingFilterProxy
 *		</filter-class>
 *	</filter> 
 *	<filter-mapping>
 *		<filter-name>springSecurityFilterChain</filter-name>
 *		<url-pattern>/*</url-pattern>
 *	</filter-mapping>
 *	</p>
 * @author idak
 *
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {}