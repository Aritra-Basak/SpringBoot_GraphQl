package com.springboot.GraphQl.service;

import com.springboot.GraphQl.entity.Genre;

import java.util.List;

/**
 * @author Aritra
 *
 */
public interface GenreServiceInterface {

    public List<Genre> getAllGenre();
    public Genre getSingleGenre(long id);
    public Genre createGenre(Genre genre);
}
