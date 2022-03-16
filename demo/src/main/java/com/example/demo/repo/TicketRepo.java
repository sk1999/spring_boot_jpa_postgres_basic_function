package com.example.demo.repo;

import com.example.demo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepo extends JpaRepository<Ticket, String> {

    Optional<Ticket> findTicketById(String ticketId);

    void deleteTicketById(String ticketId);
}
