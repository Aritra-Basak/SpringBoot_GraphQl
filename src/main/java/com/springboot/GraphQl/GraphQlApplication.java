package com.springboot.GraphQl;

import com.springboot.GraphQl.entity.BookGenre;
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

		List<BookGenre> genreList = new ArrayList<>();
		BookGenre bg1 = new BookGenre();
		bg1.setType("Thriller");
		genreList.add(bg1);
		BookGenre bg2 = new BookGenre();
		bg2.setType("Fictional");
		genreList.add(bg2);
		BookGenre bg3 = new BookGenre();
		bg3.setType("Detective");
		genreList.add(bg3);
		BookGenre bg4 = new BookGenre();
		bg4.setType("Informative");
		genreList.add(bg4);
		BookGenre bg5 = new BookGenre();
		bg5.setType("Other");
		genreList.add(bg5);


		genreRepo.saveAll(genreList);

	}

}
