package com.springboot.GraphQl.repository;

import com.springboot.GraphQl.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO to use JDBC Template of Spring-framework to process custom Query to fetch the required results.
 * @author Aritra
 * **/

@Repository
public class BookAndGenreTogether {

    private final JdbcTemplate jdbcTemplate;

    public BookAndGenreTogether(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAllBookAndGenre() {
        String sql = "SELECT pb.ID, pb.TITLE, pb.DESC, pb.AUTHOR, pb.PRICE, pb.PAGES, gt.TYPE AS GENRE_TYPE " +
                "FROM project_books pb " +
                "INNER JOIN genre_type gt ON pb.GENRE_ID = gt.ID";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("ID"));
            book.setTitle(rs.getString("TITLE"));
            book.setDesc(rs.getString("DESC"));
            book.setAuthor(rs.getString("AUTHOR"));
            book.setPrice(rs.getDouble("PRICE"));
            book.setPages(rs.getInt("PAGES"));
            book.setGenreType(rs.getString("GENRE_TYPE"));
            return book;
        });
        //(rs, rowNum) -> {...}: This is a lambda expression that processes the results of the SQL query.It is called for each row in the result set.
        //rs: Stands for ResultSet. It represents the result set of the executed query, which contains the data retrieved from the database.
        //rowNum: Represents the current row number in the result set.
        //The query method returns a list of objects, where each object represents a row in the result set.
        // The lambda expression defines how each row is mapped to an object.
    }

    @SuppressWarnings("deprecation")
	public Book getSingleBookAndGenre(int id) {
        String sql = "SELECT pb.ID, pb.TITLE, pb.DESC, pb.AUTHOR, pb.PRICE, pb.PAGES, gt.TYPE AS GENRE_TYPE " +
                "FROM project_books pb " +
                "INNER JOIN genre_type gt ON pb.GENRE_ID = gt.ID WHERE pb.ID = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("ID"));
            book.setTitle(rs.getString("TITLE"));
            book.setDesc(rs.getString("DESC"));
            book.setAuthor(rs.getString("AUTHOR"));
            book.setPrice(rs.getDouble("PRICE"));
            book.setPages(rs.getInt("PAGES"));
            book.setGenreType(rs.getString("GENRE_TYPE"));
            return book;
        });
        
    }
}
