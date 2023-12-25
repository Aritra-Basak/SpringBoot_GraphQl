package com.springboot.GraphQl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.GraphQl.entity.Genre;

/**
 * @author Aritra
 *
 */
@Repository
public interface BookGenreRepo extends JpaRepository<Genre, Long> {
}
