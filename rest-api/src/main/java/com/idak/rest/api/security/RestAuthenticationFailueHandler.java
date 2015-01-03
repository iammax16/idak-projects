package com.idak.rest.api.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import static com.idak.rest.api.util.ApiUtils.*;

/**
 * Permet de modifier le comportement par défaut qui est l'affichage 
 * d'un formulaire d'authentification avec le message d'erreur : échec d'authentification.
 * <p>
 * Le méthode onAuthenticationFailure retourne un flux json avec le statut 401 (Non authorisé)
 * response = {"status":401, "error" :  "username/password incorrect"}
 * </p>
 * @author idak
 * 
 */
@Component("authenticationFailureHandler")
public class RestAuthenticationFailueHandler extends SimpleUrlAuthenticationFailureHandler {
 
  @Override
public void onAuthenticationFailure(HttpServletRequest request,
		HttpServletResponse response, AuthenticationException exception)
		throws IOException, ServletException {
	  response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.setContentType(APPLICATION_JSON_TYPE);
      Map<String, Object> jsonMessage = new TreeMap<>();
      ObjectMapper mapper = new ObjectMapper();
      
      jsonMessage.put(STATUS_JSON_LABEL, HttpServletResponse.SC_UNAUTHORIZED);
      jsonMessage.put("error", FAILURE_AUTHENT_MESSAGE);
      
      PrintWriter writer = response.getWriter();
      mapper.writeValue(writer, jsonMessage);
      writer.flush();
}

}
