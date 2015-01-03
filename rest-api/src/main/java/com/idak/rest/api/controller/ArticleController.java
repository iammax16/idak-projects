package com.idak.rest.api.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idak.rest.api.model.Article;
import com.idak.rest.api.service.ArticleService;

@RestController
@RequestMapping("/api")
public class ArticleController {

	@Resource
	private ArticleService articleService;
	
	@RequestMapping(value="/articles", method=RequestMethod.GET)
	public List<Article> getAllArticles(){
		return articleService.getAll();
	}
	
	@RequestMapping(value="/article/{id}", method=RequestMethod.GET)
	public Article getArticleById(@PathVariable Long id){
		return articleService.getArticleById(id);
	}
	
	
}
