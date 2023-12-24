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
	*For creating an entry in the DB of type Book.
	* Using MutationMapping to map the query from schema which will create a new entry
	* **/
	@MutationMapping("createBook")
	public Book create(@Argument BookInput book) {
		//In @Argument keep the object reference variable name as same as that of the Query's parameter value reference.
		//Like in query ->createBook(book:BookInput):Book so the @Argument object reference variable will be book.
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
	 *For Fetching a single entry from the DB of type Book.
	 * Using QueryMapping to map the query from schema which will fetch a single entry
	 * **/
	@QueryMapping("getBook")
	public Book getBook(@Argument int bookId){
		return bookService.getSingleBook(bookId);
	}

	/*
	 *For Fetching a Multiple entries from the DB of type Book.
	 * Using QueryMapping to map the query from schema which will fetch multiple entries
	 * **/
	@QueryMapping("allBooks")
	public List<Book> getAllBook(){
		return bookService.getAll();
	}
	
	/*
	 *For Fetching Book with its respective Genre from DB.
	 * Using QueryMapping to map the query from schema which will fetch multiple required entries
	 * **/
	@QueryMapping("allBooksAndGenre")
	public List<Book> getAllBookAndGenre(){
		return bookService.getAllBookAndGenre();
		}
	
	@QueryMapping("getBookAndGenre")
	public Book getBookAndGenre(@Argument int bookId) throws Exception{
		return bookService.getSingleBookAndGenre(bookId);
	}
	
	
	/*
	 *For creating an entry in the DB of type Genre.
	 * Using MutationMapping to map the query from schema which will create the required entry
	 * **/
	@MutationMapping("createGenre")
	public Genre createGenre(@Argument GenreInput genre) {
		Genre gn = new Genre();
		gn.setGenreType(genre.getGenreType());
		return genreService.createGenre(gn);	
	}
	
	/*
	 *For Fetching all the Genre with all the Books available of that respective Genre from DB.
	 * Using QueryMapping to map the query from schema which will fetch multiple required entries
	 * **/	
	@QueryMapping("allGenre")
	public List<Genre> getAllGenre(){
		return genreService.getAllGenre();
		}

	/*
	 *For Fetching the Genre with all the Books available of that respective Genre from DB.
	 * Using QueryMapping to map the query from schema which will fetch single required entries
	 * **/	
	@QueryMapping("getGenre")
	public Genre getGenre(@Argument int genreId){
		return genreService.getSingleGenre(genreId);
	}

}
