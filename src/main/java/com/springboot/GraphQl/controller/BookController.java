/**
 * 
 */
package com.springboot.GraphQl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.GraphQl.entity.Book;
import com.springboot.GraphQl.service.BookServiceInterface;

/**
 * @author Aritra
 *
 */
@RestController
@RequestMapping(value="/book")
public class BookController {
	
	@Autowired
	private BookServiceInterface bookService;
	
	@PostMapping(value="/create")
	public ResponseEntity<Book> create(@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.create(book),HttpStatus.CREATED);
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<Book> getBook(@RequestParam int id){
		return new ResponseEntity<Book>(bookService.getSingleBook(id),HttpStatus.OK);
	}
	
	@GetMapping(value="/get/all")
	public ResponseEntity<List<Book>> getAllBook(){
		return new ResponseEntity<List<Book>>(bookService.getAll(),HttpStatus.OK);
	}

}
