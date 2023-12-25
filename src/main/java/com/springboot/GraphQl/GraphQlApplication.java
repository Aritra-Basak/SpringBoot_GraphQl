package com.springboot.GraphQl;

import com.springboot.GraphQl.entity.Genre;
import com.springboot.GraphQl.repository.BookGenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.GraphQl.entity.Book;
import com.springboot.GraphQl.repository.BookRepo;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GraphQlApplication implements CommandLineRunner{

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private BookGenreRepo genreRepo;

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//This method will run as soon as the our Spring boot application is started. It overriden from the interface CommandLineRunner.
		List<Book> listOfBooks = new ArrayList<>();
		Book b1 = Book.builder().title("Complete Reference in Java").desc("The best to learn core Java").genreId(4).author("Herbert Schildt").pages(800).price(1200).build();
		listOfBooks.add(b1);
		
		Book b2 =Book.builder().title("Witcher").desc("The book of the Witcher Saga").author("Andrzej Sapkowski").genreId(2).pages(1200).price(2000).build();
		listOfBooks.add(b2);
		
		Book b3 = Book.builder().title("Harry Potter: The prisioner of Azkaban").desc("One of the book of the Harry Potter Saga").author("J k Rowling").genreId(2).pages(860).price(1500).build();
		listOfBooks.add(b3);
		
		bookRepo.saveAll(listOfBooks);

		List<Genre> genreList = new ArrayList<>();
		Genre bg1 = new Genre();
		bg1.setGenreType("thriller");
		genreList.add(bg1);
		Genre bg2 = new Genre();
		bg2.setGenreType("fictional");
		genreList.add(bg2);
		Genre bg3 = new Genre();
		bg3.setGenreType("detective");
		genreList.add(bg3);
		Genre bg4 = new Genre();
		bg4.setGenreType("informative");
		genreList.add(bg4);

		genreRepo.saveAll(genreList);

	}

}
