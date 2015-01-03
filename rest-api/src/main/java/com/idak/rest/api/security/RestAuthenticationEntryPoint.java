package com.idak.rest.api.security;

import static com.idak.rest.api.util.ApiUtils.APPLICATION_JSON_TYPE;
import static com.idak.rest.api.util.ApiUtils.FAILURE_MESSAGE;
import static com.idak.rest.api.util.ApiUtils.STATUS_JSON_LABEL;
import static com.idak.rest.api.util.ApiUtils.ERROR_JSON_LABEL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Permet de modifier le comportement par défaut qui est l'affichage 
 * d'un formulaire d'authentification.
 * <p>
 * Le méthode commence retourne un flux json avec le statut 401 (Non authorisé)
 * response = {"status":401, "error" :  "Non-Autorisé, vous devez vous connecter en utilisant /auth, pour pouvoir utiliser l'api"}
 * </p>
 * @author idak
 * 
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
 
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException ex) throws IOException, ServletException {
    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(APPLICATION_JSON_TYPE);
        
        ObjectMapper mapper = new ObjectMapper();
        
        Map<String, Object> jsonMessage = new TreeMap<>();
        jsonMessage.put(STATUS_JSON_LABEL, HttpServletResponse.SC_UNAUTHORIZED);
        jsonMessage.put(ERROR_JSON_LABEL, FAILURE_MESSAGE);
        
        PrintWriter writer = response.getWriter();
        mapper.writeValue(writer, jsonMessage);
        writer.flush();
 
    }
 
}