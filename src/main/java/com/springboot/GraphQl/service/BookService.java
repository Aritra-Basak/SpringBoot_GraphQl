/**
 * 
 */
package com.springboot.GraphQl.service;

import java.util.List;

import com.springboot.GraphQl.repository.BookAndGenreTogether;
import com.springboot.GraphQl.repository.BookGenreRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.GraphQl.entity.Book;
import com.springboot.GraphQl.entity.BookInput;
import com.springboot.GraphQl.entity.Genre;
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
	
	@Autowired
	private BookGenreRepo genreRepo;
	
	@Override
	public Book create(BookInput book) {
		Book b=new Book();
		b.setTitle(book.getTitle());
		b.setDesc(book.getDesc());
		b.setPrice(book.getPrice());
		b.setAuthor(book.getAuthor());
		b.setPages(book.getPages());
		String genreValue=book.getGenre().trim().toLowerCase();
		Genre gg = new Genre();
		gg=genreRepo.getByGenreType(genreValue);
		if(gg==null) {
			Genre newGenre = new Genre();
			newGenre.setGenreType(genreValue);
			newGenre = genreRepo.save(newGenre);
			b.setGenreId(newGenre.getId());
		}
		else{
			b.setGenreId(gg.getId());
		}
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
