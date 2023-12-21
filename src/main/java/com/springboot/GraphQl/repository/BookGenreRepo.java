package com.springboot.GraphQl.repository;

import com.springboot.GraphQl.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.GraphQl.entity.BookGenre;

/**
 * @author Aritra
 *
 */
@Repository
public interface BookGenreRepo extends JpaRepository<BookGenre, Long> {
}
