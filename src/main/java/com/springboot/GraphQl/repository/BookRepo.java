/**
 * 
 */
package com.springboot.GraphQl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.GraphQl.entity.Book;

/**
 * @author Aritra
 *
 */
@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
	
	public List<Book> getByGenreId(long genreId);

}
