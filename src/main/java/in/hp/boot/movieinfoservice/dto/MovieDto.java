package in.hp.boot.movieinfoservice.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@ApiModel("Movie Detail")
@Data
public class MovieDto {
    List<String> genres;
    private String movieId;
    private String title;
    private String desciption;
    private Integer length;
    private LocalDate release_date;
    private String global_rating;
}
