package org.iotardis.moviebackend.tmdb;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.iotardis.moviebackend.tmdb.dto.MovieDto;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TheMovieDbGateway {
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String baseUrl = "https://api.themoviedb.org/3";


    public TheMovieDbGateway(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public MovieDto getMovieById(int id) throws IOException {
        var request = new Request.Builder()
                .url(baseUrl + "/movie/" + id)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + System.getenv("TMDB_API_KEY"))
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            return objectMapper.readValue(response.body().string(), MovieDto.class);
        }
    }
}
