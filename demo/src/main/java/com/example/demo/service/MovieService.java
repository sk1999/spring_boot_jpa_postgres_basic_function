package com.example.demo.service;

import com.example.demo.entity.Movie;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo){
        this.movieRepo = movieRepo;
    }

    public Movie addMovie(Movie movie){
        movie.setMovieId(UUID.randomUUID().toString());
        return movieRepo.save(movie);
    }

    public List<Movie> findAllMovie(){
        return movieRepo.findAll();
    }

    public Movie updateMovie(Movie movie){
        return movieRepo.save(movie);
    }

    public Movie findMovieById(String movieId){
        return movieRepo.findMovieById(movieId).orElseThrow(() -> new UserNotFoundException("show by Id" + movieId + "was not found"));
    }

    public void deleteMovie(String movieId){
        movieRepo.deleteMovieById(movieId);
    }
}

