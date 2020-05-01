package in.hp.boot.movieinfoservice.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovieDto {
    private String movieId;
    private String title;
    private String desciption;
    private Integer length;
    private LocalDate release_date;
    private String global_rating;
    List<String> genres;
}
