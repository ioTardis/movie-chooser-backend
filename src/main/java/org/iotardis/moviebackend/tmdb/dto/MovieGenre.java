package org.iotardis.moviebackend.tmdb.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class MovieGenre {
    int id;
    String name;
}
