/**
 * 
 */
package com.springboot.GraphQl.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
@Table(name="project_books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String title;
	String desc;
	String author;
	double price;
	int pages;
	@JsonProperty(value ="genre_id")
	@Column(name = "genre_id")
	int genreId;
	@JsonProperty(value="genre_type")
	@Transient
	String genreType;
}
