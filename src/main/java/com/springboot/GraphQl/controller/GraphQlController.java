/**
 * 
 */
package com.springboot.GraphQl.controller;

import java.util.List;

import com.springboot.GraphQl.entity.*;
import com.springboot.GraphQl.service.GenreServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import com.springboot.GraphQl.service.BookServiceInterface;

/**
 * Controller for mapping the GraphQl Queries with the API endpoints
 * @author Aritra
 *
 *
 */
@Controller
public class GraphQlController {
	
	@Autowired
	private BookServiceInterface bookService;

	@Autowired
	private GenreServiceInterface genreService;

	/*
	*For creating an entry in the DB.
	* Using MutationMapping to map the query from schema which will create a new entry
	* **/
	@MutationMapping("createBook")
	public Book create(@Argument BookInput book) {
		Book b=new Book();
		b.setTitle(book.getTitle());
		b.setDesc(book.getDesc());
		b.setPrice(book.getPrice());
		b.setAuthor(book.getAuthor());
		b.setPages(book.getPages());
		if(book.getGenre().equalsIgnoreCase("Thriller"))
			b.setGenreId(1);
		else if (book.getGenre().equalsIgnoreCase("Fictional"))
			b.setGenreId(2);
		else if (book.getGenre().equalsIgnoreCase("Detective"))
			b.setGenreId(3);
		else if (book.getGenre().equalsIgnoreCase("Informative"))
			b.setGenreId(4);
		else
			b.setGenreId(5);
		return bookService.create(b);
	}
	/*
	 *For Fetching a single entry from the DB.
	 * Using QueryMapping to map the query from schema which will fetch a single entry
	 * **/
	
	@QueryMapping("getBook")
	public Book getBook(@Argument int bookId){
		return bookService.getSingleBook(bookId);
	}

	/*
	 *For Fetching a Multiple entries from the DB.
	 * Using QueryMapping to map the query from schema which will fetch multiple entries
	 * **/

	@QueryMapping("allBooks")
	public List<Book> getAllBook(){
		return bookService.getAll();
	}

	@QueryMapping("allBooksAndGenre")
	public List<Book> getAllBookAndGenre(){ return bookService.getAllBookAndGenre();}

	@QueryMapping("allGenre")
	public List<BookGenre> getAllGenre(){return genreService.getAllGenre(); }

	@QueryMapping("getGenre")
	public BookGenre getGenre(@Argument long id){return  genreService.getSingleGenre(id);}

	@MutationMapping("createBookGenre")
	public BookGenre createGenre(@Argument BookGenreInput bookGenreInput){
		BookGenre bg = new BookGenre();
		bg.setGenreType(bookGenreInput.getGenreType());
		return genreService.createGenre(bg);
	}
	

}
