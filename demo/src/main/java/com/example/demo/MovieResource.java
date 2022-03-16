package com.example.demo;


import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {
    private final MovieService movieServices;

    public MovieResource(MovieService movieServices) {
        this.movieServices = movieServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovie() {
        List<Movie> movie = movieServices.findAllMovie();
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/find/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable("movieId") String movieId) {
        Movie movie = movieServices.findMovieById(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie newMovie = movieServices.addMovie(movie);
        return new ResponseEntity<>(newMovie, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        Movie updateMovie = movieServices.updateMovie(movie);
        return new ResponseEntity<>(updateMovie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable("movieId") String movieId){
        movieServices.deleteMovie(movieId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
