package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private String movieId;
    private String movieName;
    private LocalDateTime Time = LocalDateTime.of(2022,03,14,7,30,00);
    private Integer noOfSeats ;
    private String ScreenNo;

    public Movie() {
    }

    public Movie(String movieName, LocalDateTime time, Integer noOfSeats, String screenNo) {
        this.movieName = movieName;
        Time = time;
        this.noOfSeats = noOfSeats;
        ScreenNo = screenNo;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDateTime getTime() {
        return Time;
    }

    public void setTime(LocalDateTime time) {
        Time = time;
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getScreenNo() {
        return ScreenNo;
    }

    public void setScreenNo(String screenNo) {
        ScreenNo = screenNo;
    }

    public void setMovieId(String MovieId) {
        this.movieId = MovieId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", Time=" + Time +
                ", noOfSeats=" + noOfSeats +
                ", ScreenNo='" + ScreenNo + '\'' +
                '}';
    }
}
