package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ticket;
import com.example.demo.repo.TicketRepository;

@Service
public class TicketService {

	 @Autowired
	    private TicketRepository repo;

	    // -------------- VALIDATION COMMON METHOD --------------
	    public void validateTicket(Ticket ticket) {
	        
	        // Validate mobile number (exact 10 digits)
	        if (!ticket.getCustomerMobile().matches("\\d{10}")) {
	            throw new IllegalArgumentException("Invalid mobile number. Must be exactly 10 digits.");
	        }

	        // Validate status
	        List<String> validStatus = Arrays.asList("open", "processing", "closed");
	        if (!validStatus.contains(ticket.getStatus().toLowerCase())) {
	            throw new IllegalArgumentException("Invalid status. Must be open, processing, closed.");
	        }
	    }

	    // ------------------ ADD TICKET -----------------------
	    public Ticket addTicket(Ticket ticket) {
	        
	        if (repo.existsById(ticket.getId())) {
	            throw new RuntimeException("Ticket ID already exists");
	        }

	        validateTicket(ticket);
	        return repo.save(ticket);
	    }

	    // ---------------- UPDATE TICKET ----------------------
	    public Ticket updateTicket(Ticket ticket) {

	        if (!repo.existsById(ticket.getId())) {
	            throw new NoSuchElementException("Ticket ID not found");
	        }

	        validateTicket(ticket);
	        return repo.save(ticket);
	    }

	    // ---------------- DELETE TICKET ----------------------
	    public void deleteTicket(Integer id) {
	        if (!repo.existsById(id)) {
	            throw new NoSuchElementException("Ticket not found");
	        }
	        repo.deleteById(id);
	    }

	    // ---------------- GET ALL TICKETS --------------------
	    public List<Ticket> getAllTickets() {
	        return repo.findAll();
	    }
	    
	    public Optional<Ticket> searchByTicketId(int id) {
	    	 return repo.findById(id);
	    }

	    // ---------------- SEARCH BY TITLE --------------------
	    public List<Ticket> searchByTitle(String title) {
	        return repo.findByTitleContainingIgnoreCase(title);
	    }

}
