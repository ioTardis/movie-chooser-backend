package org.iotardis.moviebackend.tmdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class TheMovieDbGateway {
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String baseUrl = "https://api.themoviedb.org/3";


    public TheMovieDbGateway(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public MovieResponse getMovieById(int id) throws IOException {
        var request = new Request.Builder()
                .url(baseUrl + "/movie/" + id)
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + System.getenv("TMDB_API_KEY"))
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            return objectMapper.readValue(response.body().string(), MovieResponse.class);
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record MovieResponse(
            List<Genre> genres,
            Integer id,
            String overview,
            String title
    ) {}

    public record Genre(
            int id,
            String name
    ) {}

}
