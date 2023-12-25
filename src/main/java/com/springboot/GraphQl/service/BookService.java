/**
 * 
 */
package com.springboot.GraphQl.service;

import java.util.List;

import com.springboot.GraphQl.repository.BookAndGenreTogether;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.GraphQl.entity.Book;
import com.springboot.GraphQl.entity.BookInput;
import com.springboot.GraphQl.repository.BookRepo;

/**
 * @author Aritra
 *
 */
@Service
public class BookService implements BookServiceInterface {

	@Autowired
	private BookRepo bookRep;

	@Autowired
	private BookAndGenreTogether bgt;
	
	@Override
	public Book create(BookInput book) {
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

		return bookRep.save(b);
	}

	@Override
	public List<Book> getAll() {
		return bookRep.findAll();
	}
	
	@Override
	public Book getSingleBook(int bookId) {
		return bookRep.findById(bookId).orElseThrow(()->new RuntimeException("The Book you are looking for, not found in the server."));
	}
	
	@Override
	public List<Book> getAllBookAndGenre() {
		return bgt.getAllBookAndGenre();
	}
 	
	@Override
	public Book getSingleBookAndGenre(int bookId) throws Exception {
		Book bk =bgt.getSingleBookAndGenre(bookId);
		if(bk!=null)
			return bk;
		else
			throw new Exception("The Book you are looking for, not found in the server.");
	}

}
