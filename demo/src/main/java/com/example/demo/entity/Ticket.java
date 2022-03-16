package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private String ticketId;
    private String seatNos;
    private String movieId;
    private String customerId;

    public Ticket() {
    }

    public Ticket(String seatNos, String movieId, String customerId) {
        this.seatNos = seatNos;
        this.movieId = movieId;
        this.customerId = customerId;
    }

    public String getSeatNos() {
        return seatNos;
    }

    public void setSeatNos(String seatNos) {
        this.seatNos = seatNos;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", seatNos=" + seatNos +
                ", movieId='" + movieId + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
