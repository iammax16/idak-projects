package com.idak.rest.api.security;

import static com.idak.rest.api.util.ApiUtils.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Permet de modifier le comportement par défaut qui est l'affichage 
 * la page d'accueil ou redirection vers l'url postée .
 * <p>
 * Le méthode onAuthenticationSuccess retourne un flux json avec le statut 200 (succès)
 * response = {"status":200, "error" :  "Vous ête connecté, désormais vous pouvez utiliser l'api"}
 * </p>
 * @author idak
 * 
 */
@Component("authenticationSuccessHandler")
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
            final HttpServletResponse response, final Authentication authentication)
            throws ServletException, IOException {
    	
    	response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType(APPLICATION_JSON_TYPE);
        Map<String, Object> jsonMessage = new TreeMap<>();
        ObjectMapper mapper = new ObjectMapper();
        
        jsonMessage.put(STATUS_JSON_LABEL, HttpServletResponse.SC_OK);
        jsonMessage.put(MESSAGE_JSON_LABEL, SUCCESS_MESSAGE);
        
        PrintWriter writer = response.getWriter();
        mapper.writeValue(writer, jsonMessage);
        writer.flush();
    }
}
