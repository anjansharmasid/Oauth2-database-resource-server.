package com.tc.poc.networkdb.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tc.poc.networkdb.model.Customer;
import com.tc.poc.networkdb.model.SportEvents;
import com.tc.poc.networkdb.repository.CustomerRepository;
import com.tc.poc.networkdb.repository.SportEventsRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
public class CustomerController {
	
	   @Autowired
	   private CustomerRepository repository;
	   
	   @Autowired
	   private SportEventsRepository sportEventsRepository;
	   
	   public CustomerController(CustomerRepository repository,SportEventsRepository sportEventsRepository) {
	        this.repository = repository;
	        this.sportEventsRepository = sportEventsRepository;
	    }

	   @GetMapping("/customers")
	   @PreAuthorize("hasAnyAuthority('role_admin','role_user','role_apiuser')")
	   public List<Customer> retrieveAllCustomers() {
		   	populateAgain();
	   		return repository.findAll();
	   }
	   
	   
	   @GetMapping("/customers/{id}")
	   @PreAuthorize("hasAnyAuthority('role_admin','role_user','role_apiuser')")
	   public Optional<Customer> retrieveAllCustomers(@PathVariable("id") Long id) {
	   		return repository.findById(id);
	   }
	   
	   @GetMapping("/good-customers")
	   @PreAuthorize("hasAuthority('role_admin')")
	   public Collection<Customer> goodCustomer() {
	        return repository.findAll().stream().filter(this::isGreat).collect(Collectors.toList());
	   }

	    private boolean isGreat(Customer customer) {
	        return !customer.getName().equals("Budweiser") &&  !customer.getName().equals("Coors Light") && !customer.getName().equals("PBR");
	    }
	    
	    @PostMapping("/customer/post")
	    @PreAuthorize("hasAuthority('role_admin')")
	    public Optional<Customer> createStudent(@RequestBody Customer customer) {
	    	Customer customerSaved = repository.save(customer);
	    	return repository.findById(customerSaved.getId());
	    }
	    
	    private void populateAgain() {
	    	try {
	    		Stream.of("Kent Brunch", "GoodDay", "Hazy", "Julius","Budwei", "Coor", "PBRMOR").forEach(name -> repository.saveAndFlush(new Customer(name)));
	    	}
	    	catch(Exception e) {
	    		System.out.println(e.getCause().getMessage());
	    	}
	    }
	    
	    @GetMapping("/events")   
	    @PreAuthorize("hasAuthority('role_apiuser')")
		public List<SportEvents> retrieveAllSportEvents() {
		   	return sportEventsRepository.findAll();
		   }
	    
	    @GetMapping("/test")   
		public String testApplication() {
		   	return "Application is working. You will need acess_token to access other resources of the application.";
		   }
}
