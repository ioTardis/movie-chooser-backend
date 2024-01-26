package org.iotardis.moviebackend.tmdb.dto;

import lombok.Builder;

import java.util.List;

@Builder
public class MovieDto {
    int id;
    String title;
    String description;
    List<Integer> genres;
}
