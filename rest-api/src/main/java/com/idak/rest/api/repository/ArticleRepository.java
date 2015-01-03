package com.idak.rest.api.repository;

import java.util.List;

import com.idak.rest.api.model.Article;

public interface ArticleRepository {
	
	static final String GET_ALL_ARTICLES = "SELECT * FROM ARTICLE";
	static final String GET_ARTICLE_BY_ISBN = "SELECT * FROM ARTICLE WHERE ISBN = ?";
	static final String GET_ARTICLE_BY_ID = "SELECT * FROM ARTICLE WHERE ARTICLE_ID = ?";
	
	/**
	 * get All articles
	 * @return List<Article>
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
	 * @return Article
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
