/**
 * 
 */
package com.springboot.GraphQl.service;

import java.util.List;

import com.springboot.GraphQl.entity.Book;

/**
 * @author Aritra
 *
 */
public interface BookServiceInterface {
	public Book create(Book book);
	public List<Book> getAll();
	public Book getSingleBook(int bookId);
	public List<Book> getAllBookAndGenre() ;
	
}
