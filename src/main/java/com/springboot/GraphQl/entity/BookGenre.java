/**
 * 
 */
package com.springboot.GraphQl.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @author Aritra
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name="genre_type")
public class BookGenre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	@Column(name = "type")
	String genreType;
	@OneToMany
	List<Book> books;

}
