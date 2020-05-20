package in.hp.boot.movieinfoservice.services;

import in.hp.boot.movieinfoservice.dto.MovieDto;
import in.hp.boot.movieinfoservice.mapper.MovieToMovieDtoMapper;
import in.hp.boot.movieinfoservice.models.Movie;
import in.hp.boot.movieinfoservice.utils.MovieInfoServiceUrlHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MovieInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieToMovieDtoMapper movieToMovieDtoMapper;

    @Autowired
    private MovieInfoServiceUrlHelper movieInfoServiceUrlHelper;

    public MovieDto getMovie(String id) {
        log.info("getMovie movieId [{}]", id);
        Movie movie = restTemplate.getForObject(movieInfoServiceUrlHelper.getMovieUriId(id), Movie.class);
        log.info("getMovie done movieId [{}]", id);
        return movieToMovieDtoMapper.toMovieDto(movie);
    }
}
