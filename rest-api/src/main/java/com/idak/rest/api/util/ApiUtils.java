package com.idak.rest.api.util;

public class ApiUtils {
	//TODO I18N : remplacer les constantes par des libellés dans d'un fichier de messages.
	public static final String SUCCESS_MESSAGE       	= "Vous ête connecté, désormais vous pouvez utiliser l'api";
	public static final String FAILURE_MESSAGE       	= "Non-Autorisé, vous devez vous connecter (host/auth), pour pouvoir utiliser l'api";
	public static final String FAILURE_AUTHENT_MESSAGE  = "username/password incorrect";
	public static final String APPLICATION_JSON_TYPE 	= "application/json;charset=utf8";
	public static final String STATUS_JSON_LABEL     	= "status";
	public static final String ERROR_JSON_LABEL      	= "error";
	public static final String MESSAGE_JSON_LABEL    	= "message";
	public static final String ARTICLE_NOT_FOUND    	= "Article introuvable";
	
}
