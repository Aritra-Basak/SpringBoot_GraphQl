package com.springboot.GraphQl.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * BookInput is a pojo class for creating an entity in the db via GraphQl. Which contains all the parameters that
 * needs to be passed while creating a mutation query.
 * @author Aritra
 *
 * **/


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BookInput {

    String title;
    String desc;
    String author;
    double price;
    int pages;
    String genre;


}
