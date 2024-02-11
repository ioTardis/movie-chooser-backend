package org.iotardis.moviebackend.tmdb;

import org.iotardis.moviebackend.tmdb.dto.MovieDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TheMovieDbController {
    private final TheMovieDbGateway theMovieDbGateway;

    public TheMovieDbController(TheMovieDbGateway theMovieDbGateway) {
        this.theMovieDbGateway = theMovieDbGateway;
    }

    @GetMapping("/tmdb/movie/{id}")
    public MovieDto getMovieById(@PathVariable int id) throws IOException {
        return theMovieDbGateway.getMovieById(id);
    }
}
