package in.hp.boot.movieinfoservice.controllers;

import in.hp.boot.movieinfoservice.dto.MovieDto;
import in.hp.boot.movieinfoservice.services.MovieInfoService;
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

    @GetMapping("{id}")
    public MovieDto getInfo(@PathVariable String id) {
        return movieInfoService.getMovie(id);
    }
}
