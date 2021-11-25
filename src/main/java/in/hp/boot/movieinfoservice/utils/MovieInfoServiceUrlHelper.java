package in.hp.boot.movieinfoservice.utils;

import in.hp.boot.movieinfoservice.configs.EndpointsConfig;
import in.hp.boot.movieinfoservice.constants.MovieInfoConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieInfoServiceUrlHelper {

    @Autowired
    private EndpointsConfig endpointsConfig;

    public String getMovieUriId(String id) {
        return endpointsConfig.getBaseUrl()
                + MovieInfoConstants.MOVIE_RESOURCE
                + id
                + MovieInfoConstants.API_KEY_PARAM
                + endpointsConfig.getApiKey();
    }
}
