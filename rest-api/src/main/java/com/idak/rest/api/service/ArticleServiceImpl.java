package com.idak.rest.api.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idak.rest.api.model.Article;
import com.idak.rest.api.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Resource
	private  ArticleRepository articleRepository;
	
	@Override
	public List<Article> getAll() {
		return articleRepository.getAll();
	}
	
	@Override
	public Article getArticleById(Long id) {
		return articleRepository.getArticleById(id);
	}

	@Override
	public Article getArticleByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
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
