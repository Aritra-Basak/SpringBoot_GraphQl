package com.springboot.GraphQl.service;

import com.springboot.GraphQl.entity.Book;
import com.springboot.GraphQl.entity.Genre;
import com.springboot.GraphQl.repository.BookGenreRepo;
import com.springboot.GraphQl.repository.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author Aritra
 *
 */
@Service
public class GenreService implements GenreServiceInterface {
	
    @Autowired
    private BookGenreRepo genreRepo;
    
    @Autowired
    private BookRepo br;

    @Override
    public List<Genre> getAllGenre(){
    	List<Genre> bgl = genreRepo.findAll();
    	bgl.forEach((x)->{
    		List<Book> bkl = br.getByGenreId(x.getId());
    		x.setBooks(bkl);
    	});	
        return bgl;
    }

    @Override
    public Genre getSingleGenre(long id){
    	Genre gg =genreRepo.findById(id).orElseThrow(()->new RuntimeException("The Genre you are looking for, not found in the server."));
    	List<Book> bkl = br.getByGenreId(gg.getId());
		gg.setBooks(bkl);
        return gg;
    }
    
    @Override
    public Genre createGenre(Genre genre){
        return genreRepo.save(genre);
    }
}
