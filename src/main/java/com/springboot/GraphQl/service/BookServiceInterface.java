/**
 * 
 */
package com.springboot.GraphQl.service;

import java.util.List;

import com.springboot.GraphQl.entity.Book;
import com.springboot.GraphQl.entity.BookInput;

/**
 * @author Aritra
 *
 */
public interface BookServiceInterface {
	public Book create(BookInput book);
	public List<Book> getAll();
	public Book getSingleBook(int bookId);
	public List<Book> getAllBookAndGenre() ;
	public Book getSingleBookAndGenre(int bookId) throws Exception;
	
}
