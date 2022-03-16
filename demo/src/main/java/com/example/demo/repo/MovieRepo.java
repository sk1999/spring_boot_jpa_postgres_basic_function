package com.example.demo.repo;

import com.example.demo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie, String> {

    Optional<Movie> findMovieById(String movieId);

    void deleteMovieById(String movieId);
}
