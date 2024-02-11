package org.iotardis.moviebackend.tmdb.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
public class MovieDto {

    int id;

    @NonNull
    String title;

    String description;

    List<Integer> genre;
}
