package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.TicketService;

public class CustomerController {

    private final TicketService ticketService;

    @Autowired
    public CustomerController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

}
