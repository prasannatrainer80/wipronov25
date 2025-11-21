package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;

@RestController
@RequestMapping(value="Ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
    // --------------- ADD TICKET -----------------------
    @PostMapping
    public ResponseEntity<?> addTicket(@RequestBody Ticket ticket) {
        try {
            Ticket saved = ticketService.addTicket(ticket);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } 
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } 
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // --------------- UPDATE TICKET -----------------------
    @PutMapping
    public ResponseEntity<?> updateTicket(@RequestBody Ticket ticket) {
        try {
            Ticket updated = ticketService.updateTicket(ticket);
            return ResponseEntity.ok(updated);
        } 
        catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } 
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // --------------- DELETE TICKET -----------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Integer id) {
        try {
            ticketService.deleteTicket(id);
            return ResponseEntity.ok("Ticket deleted successfully");
        } 
        catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

	
	// --------------- SEARCH BY TITLE -----------------------
    @GetMapping("/search/{title}")
    public ResponseEntity<?> search(@PathVariable String title) {
        return ResponseEntity.ok(ticketService.searchByTitle(title));
    }

	
	 // --------------- GET ALL TICKETS -----------------------
    @GetMapping(value="/showTickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    
	
}
