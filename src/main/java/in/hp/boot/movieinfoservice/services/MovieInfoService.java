package in.hp.boot.movieinfoservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "getMovieFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
    }, threadPoolKey = "movieInfoPool", threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "5"),
            @HystrixProperty(name = "maxQueueSize", value = "5")
    })
    public MovieDto getMovie(String id) {
        log.info("getMovie movieId [{}]", id);
        Movie movie = restTemplate.getForObject(movieInfoServiceUrlHelper.getMovieUriId(id), Movie.class);
        log.info("getMovie done movieId [{}]", id);
        return movieToMovieDtoMapper.toMovieDto(movie);
    }

    public MovieDto getMovieFallback(String id) {
        log.error("circuit broken for [{}], at fallback method [{}]", id, "getMovieFallback");
        MovieDto movieDto = new MovieDto();
        movieDto.setMovieId(id);
        return movieDto;
    }
}
