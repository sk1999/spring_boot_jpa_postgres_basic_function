package com.example.demo.service;

import com.example.demo.entity.Ticket;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketRepo ticketRepo;

    @Autowired
    public TicketService(TicketRepo ticketRepo){
        this.ticketRepo = ticketRepo;
    }

    public Ticket addTicket(Ticket ticket){
        ticket.setTicketId(UUID.randomUUID().toString());
        return ticketRepo.save(ticket);
    }

    public List<Ticket> findAllTicket(){
        return ticketRepo.findAll();
    }

    public Ticket updateTicket(Ticket ticket){
        return ticketRepo.save(ticket);
    }

    public Ticket findTicketById(String ticketId){
        return ticketRepo.findTicketById(ticketId).orElseThrow(() -> new UserNotFoundException("Ticket by id" + ticketId + "was not found"));
    }

    public void deleteTicket(String ticketId){
        ticketRepo.deleteTicketById(ticketId);
    }
}

