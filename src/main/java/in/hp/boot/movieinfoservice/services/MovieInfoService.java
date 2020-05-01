package in.hp.boot.movieinfoservice.services;

import in.hp.boot.movieinfoservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "https://api.themoviedb.org/3/movie/";

    private String apiKey = "?api_key=525074f1f0ee4cd494ffe0adee6b0074";

    public Movie getMovie(String id) {
        return restTemplate.getForObject(url + id + apiKey, Movie.class);
    }
}
