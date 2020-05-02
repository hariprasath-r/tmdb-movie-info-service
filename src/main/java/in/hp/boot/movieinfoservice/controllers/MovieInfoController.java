package in.hp.boot.movieinfoservice.controllers;

import in.hp.boot.movieinfoservice.dto.MovieDto;
import in.hp.boot.movieinfoservice.services.MovieInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/movie-info")
public class MovieInfoController {

    @Autowired
    private MovieInfoService movieInfoService;

    @ApiOperation(value = "Gets a Movie with specified Movie Id", response = MovieDto.class)
    @GetMapping("{movieId}")
    public MovieDto getInfo(@PathVariable String movieId) {
        return movieInfoService.getMovie(movieId);
    }
}
