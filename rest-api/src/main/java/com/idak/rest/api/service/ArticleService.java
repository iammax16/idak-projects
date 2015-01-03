package com.idak.rest.api.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.idak.rest.api.model.Article;


public interface ArticleService {
	DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	/**
	 * get All articles
	 * @return
	 */
	List<Article> getAll();
	
	/**
	 * Find article by id
	 * @param id
	 * @return Article
	 */
	Article getArticleById(Long id);
	
	/**
	 * Find article by isbn
	 * @param isbn
	 * @return
	 */
	Article getArticleByIsbn(String isbn);
	
	/**
	 * Update article
	 * @param article
	 */
	void update(Article article);
	
	/**
	 * Create Article
	 * @param article
	 * @return article Id
	 */
	Long create(Article article);
}
