package com.marketingapp3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marketingapp3.entities.Lead;
import com.marketingapp3.repositary.LeadRepositary;

@Service
public class LeadServiceImpl implements LeadService {
	@Autowired
	private LeadRepositary leadRepo;

	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		return findById.get();
	}

}
