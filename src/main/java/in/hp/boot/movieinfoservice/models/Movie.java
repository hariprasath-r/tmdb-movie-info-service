package in.hp.boot.movieinfoservice.models;

import lombok.Data;

import java.util.List;

@Data
public class Movie {
    private String id;
    private String original_title;
    private String overview;
    private String release_date;
    private String runtime;
    private String tagline;
    private String title;
    private String vote_average;
    private String vote_count;

    private List<Genre> genres;
}
