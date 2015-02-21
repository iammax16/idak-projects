package fr.idak.tutorial.ws.repository;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.idak.tutorial.ws.config.ContextConfig;
import fr.idak.tutorial.ws.model.Book;
import fr.idak.tutorial.ws.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ContextConfig.class})
public class BookRepositoryTest {
	
	@Resource
	private BookRepository articleRepository;
	
	@Test
	public void readTest(){
		Long id = 1L;
		Book article = articleRepository.get(id);
		Assert.assertNotNull(article);
		Assert.assertThat(id, is(id));
	}
	
	@Test
	public void readAll(){
		List<Book> articles = articleRepository.getAll();
		Assert.assertNotNull(articles);
		Assert.assertTrue(articles.size() > 0);
	}
}
