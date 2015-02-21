package fr.idak.tutorial.ws.web.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fr.idak.tutorial.ws.model.Book;
import fr.idak.tutorial.ws.repository.BookRepository;

@RestController
@RequestMapping(value="/api")
public class BookController {
	
	@Resource
	private BookRepository bookRepository;
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public Book getBook(@PathVariable Long id){
		return bookRepository.get(id);
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public List<Book> getBooks(){
		return bookRepository.getAll();
	}		
}
