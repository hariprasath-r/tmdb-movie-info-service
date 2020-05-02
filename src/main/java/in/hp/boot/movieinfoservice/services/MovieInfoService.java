package in.hp.boot.movieinfoservice.services;

import in.hp.boot.movieinfoservice.dto.MovieDto;
import in.hp.boot.movieinfoservice.mapper.MovieToMovieDtoMapper;
import in.hp.boot.movieinfoservice.models.Movie;
import in.hp.boot.movieinfoservice.utils.MovieInfoServiceUrlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieToMovieDtoMapper movieToMovieDtoMapper;

    @Autowired
    private MovieInfoServiceUrlHelper movieInfoServiceUrlHelper;

    public MovieDto getMovie(String id) {
        Movie movie = restTemplate.getForObject(movieInfoServiceUrlHelper.getMovieUriId(id), Movie.class);
        return movieToMovieDtoMapper.toMovieDto(movie);
    }
}
