package com.springboot.GraphQl.service;

import com.springboot.GraphQl.entity.BookGenre;
import com.springboot.GraphQl.repository.BookGenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author Aritra
 *
 */
@Service
public class GenreService {
    @Autowired
    private BookGenreRepo genreRepo;

    public List<BookGenre> getAllGenre(){
       return genreRepo.findAll();
    }

    public BookGenre getSingleGenre(long id){
        return genreRepo.findById(id).orElseThrow(()->new RuntimeException("The Genre you are looking for, not found in the server."));
    }

    public BookGenre createGenre(BookGenre genre){
        return genreRepo.save(genre);
    }
}
