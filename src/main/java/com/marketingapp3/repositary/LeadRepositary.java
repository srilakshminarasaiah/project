package com.marketingapp3.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp3.entities.Lead;

public interface LeadRepositary extends JpaRepository<Lead, Long> {

}
