package org.iotardis.moviebackend.tmdb.mapper;

import org.iotardis.moviebackend.tmdb.TheMovieDbGateway;
import org.iotardis.moviebackend.tmdb.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieResponseToMovieDto {
    MovieResponseToMovieDto INSTANCE = Mappers.getMapper(MovieResponseToMovieDto.class);

    @Mapping(target = "description", source = "overview")
    @Mapping(target = "genres", source = "genres")
    MovieDto movieResponseToMovieDto(TheMovieDbGateway.MovieResponse movieResponse);
}
