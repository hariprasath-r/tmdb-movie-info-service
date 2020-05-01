package in.hp.boot.movieinfoservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/movie-info")
public class MovieInfoController {

    @GetMapping
    public String getInfo() {
        return "Movie-info-service";
    }
}
