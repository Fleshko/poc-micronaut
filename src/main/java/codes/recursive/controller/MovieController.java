package codes.recursive.controller;

import codes.recursive.domain.Movie;
import codes.recursive.repository.MovieRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

@Controller("/movie")
@SuppressWarnings({"rawtypes"})
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Get()
    public HttpResponse getMovies() {
        return HttpResponse.ok(
                movieRepository.findAll()
        );
    }

    @Get(uri = "/{movieId}")
    public HttpResponse getMovie(String movieId) {
        return HttpResponse.ok( movieRepository.findById(movieId) );
    }

    @Get(uri = "/title/{movieTitle}")
    public HttpResponse getMovieByTitle(String movieTitle) {
        return HttpResponse.ok( movieRepository.findByTitle(movieTitle) );
    }

    @Post()
    public HttpResponse saveMovie(@Body Movie movie) {
        movieRepository.save(movie);
        return HttpResponse.created(movie);
    }

    @Put()
    public HttpResponse updateMovie(@Body Movie movie) {
        movieRepository.update(movie);
        return HttpResponse.noContent();
    }

    @Delete("/{movieId}")
    public HttpResponse deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
        return HttpResponse.noContent();
    }
}