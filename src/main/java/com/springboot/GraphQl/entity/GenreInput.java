package com.springboot.GraphQl.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
/**
 * @author Aritra
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenreInput {
    String genreType;
}
