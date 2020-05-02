package in.hp.boot.movieinfoservice.mapper;

import in.hp.boot.movieinfoservice.dto.MovieDto;
import in.hp.boot.movieinfoservice.models.Genre;
import in.hp.boot.movieinfoservice.models.Movie;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Component
public class MovieToMovieDtoMapper {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

    public MovieDto toMovieDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setMovieId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDesciption(movie.getOverview());
        movieDto.setLength(Integer.valueOf(movie.getRuntime()));
        movieDto.setRelease_date(LocalDate.parse(movie.getRelease_date()));
        movieDto.setGlobal_rating(movie.getVote_average());
        movieDto.setGenres(movie.getGenres().stream().map(Genre::getName).collect(Collectors.toList()));
        return movieDto;
    }
}
