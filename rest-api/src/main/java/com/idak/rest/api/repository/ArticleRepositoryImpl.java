package com.idak.rest.api.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.idak.rest.api.model.Article;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository{
	
	@Resource
	private JdbcTemplate jt;
	
	@Override
	public List<Article> getAll() {	
		return jt.query(GET_ALL_ARTICLES, BeanPropertyRowMapper.newInstance(Article.class));

	}

	@Override
	public Article getArticleById(Long id) {
		return jt.queryForObject(GET_ARTICLE_BY_ID, BeanPropertyRowMapper.newInstance(Article.class), id) ;
	}
	
	@Override
	public Article getArticleByIsbn(String isbn) {
		return jt.queryForObject(GET_ARTICLE_BY_ISBN, BeanPropertyRowMapper.newInstance(Article.class), isbn) ;
	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long create(Article article) {
		// TODO Auto-generated method stub
		return null;
	}
}
