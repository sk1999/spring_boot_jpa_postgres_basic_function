package com.example.demo;


import com.example.demo.entity.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketResource {
    private final TicketService ticketServices;

    public TicketResource(TicketService ticketServices) {
        this.ticketServices = ticketServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTicket() {
        List<Ticket> ticket = ticketServices.findAllTicket();
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/find/{ticketId}")
    public ResponseEntity<Ticket> getTicket(@PathVariable("ticketId") String ticketId) {
        Ticket ticket = ticketServices.findTicketById(ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Ticket> addMovie(@RequestBody Ticket ticket) {
        Ticket newTicket= ticketServices.addTicket(ticket);
        return new ResponseEntity<>(newTicket, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        Ticket updateTicket = ticketServices.updateTicket(ticket);
        return new ResponseEntity<>(updateTicket, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable("ticketId") String ticketId){
        ticketServices.deleteTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
