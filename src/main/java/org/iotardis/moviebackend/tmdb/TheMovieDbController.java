package org.iotardis.moviebackend.tmdb;

import org.iotardis.moviebackend.tmdb.dto.MovieDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheMovieDbController {

    @GetMapping("/tmdb/test")
    public MovieDto getTest() {
        return MovieDto.builder()
                .id(123)
                .title("Test")
                .description("Test description")
                .genre(List.of(1, 2, 3))
                .build();
    }
}
