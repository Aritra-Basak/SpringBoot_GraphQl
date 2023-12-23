package com.springboot.GraphQl.service;

import com.springboot.GraphQl.entity.BookGenre;

import java.util.List;

/**
 * @author Aritra
 *
 */
public interface GenreServiceInterface {

    public List<BookGenre> getAllGenre();
    public BookGenre getSingleGenre(long id);
    public BookGenre createGenre(BookGenre genre);
}
