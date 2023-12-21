/**
 * 
 */
package com.springboot.GraphQl.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.GraphQl.entity.Book;
import com.springboot.GraphQl.repository.BookRepo;

/**
 * @author Aritra
 *
 */
@Service
public class BookService implements BookServiceInterface {

	@Autowired
	private BookRepo bookRep;
	
	@Override
	public Book create(Book book) {
		return bookRep.save(book);
	}

	@Override
	public List<Book> getAll() {
		return bookRep.findAll();
	}
 
	@Override
	public Book getSingleBook(int bookId) {
		return bookRep.findById(bookId).orElseThrow(()->new RuntimeException("The Book you are looking for, not found in the server."));
	}

}
