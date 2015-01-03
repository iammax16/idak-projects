package com.idak.rest.api.service.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.idak.rest.api.model.Article;
import com.idak.rest.api.service.ArticleService;
import com.idak.rest.ws.config.ServiceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
public class ArticleServiceTest {
	@Resource
	private ArticleService articleService;
	
	@Test
	public void getAllArticles(){
		List<Article> articles = articleService.getAll();
		assertNotNull(articles);
	}
	
	@Test
	public void getArticleById(){
		Long id = Long.valueOf(1);
		Article article = articleService.getArticleById(id);
		assertEquals(id, article.getArticleId());
	}
}
