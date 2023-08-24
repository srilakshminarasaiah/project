package com.marketingapp3.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marketingapp3.entities.Lead;
import com.marketingapp3.entities.LeadDto;
import com.marketingapp3.repositary.LeadRepositary;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	@Autowired
	private LeadRepositary leadRepo;

//http://localhost:8080/api/leads
	@GetMapping
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@PostMapping
	public void CreateLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}

	@DeleteMapping("/{id}")
	public void deleteLead(@PathVariable("id") long id) {
		// http://localhost:8080/api/leads/1
		leadRepo.deleteById(id);
	}

	@PutMapping("/{id}")
	public void UpdateLead(@RequestBody LeadDto dto, @PathVariable("id") long id) {
		// http://localhost:8080/api/leads/1
		Lead l = new Lead();
		l.setId(id);
		l.setFirstName(dto.getFirstName());
		l.setLastName(dto.getLastName());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		leadRepo.save(l);
	}
}
