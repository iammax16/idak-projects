package com.idak.rest.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.idak.rest.api.model.ErrorResource;
import com.idak.rest.api.util.ApiUtils;

/**
 * Controlleur intercepte toutes les exceptions <br>
 * pour toujours revoyer  une réponse avec une message au format JSON 
 * @author idak
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	/**
	 * Traite l'exception EmptyResultDataAccessException, quand l'appel du ws ne retourne aucun résultat
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> notFound(WebRequest request, RuntimeException ex){
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ErrorResource error = new ErrorResource(HttpStatus.NOT_FOUND.value(), ApiUtils.ARTICLE_NOT_FOUND);
        
		return handleExceptionInternal(ex, error, headers, HttpStatus.NOT_FOUND, request);
	}
}
