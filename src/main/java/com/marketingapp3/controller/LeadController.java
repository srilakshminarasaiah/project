package com.marketingapp3.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.marketingapp3.entities.Lead;
import com.marketingapp3.entities.LeadDto;
import com.marketingapp3.service.LeadService;
import com.marketingapp3.utility.EmailService;
@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	@Autowired
	private EmailService emailService;

	// http://localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLead() {
		return "create_lead";
	}

	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute Lead lead, Model model) {
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(), "hello", "Vanakam da mapulaa:)");
		model.addAttribute("msg", "Record is saved!!");
		return "create_lead";
	}

	// http://localhost:8080/all
	@RequestMapping("/all")
	public String getAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "search_result";
	}

	@RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id") long id, Model model) {
		leadService.deleteLeadById(id);
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "search_result";
	}
	@RequestMapping("/update")
	public String getLeadById(@RequestParam("id")long id,Model model) {
	Lead lead =	leadService.findLeadById(id);
	model.addAttribute("lead", lead);
		return"update_lead";
	}
	@RequestMapping("/UpdateLead")
	public String updateLead(LeadDto dto, Model model) {
		Lead l = new Lead();
		l.setId(dto.getId());
		l.setFirstName(dto.getFirstName());
		l.setLastName(dto.getLastName());
		l.setEmail(dto.getEmail());
		l.setMobile(dto.getMobile());
		leadService.saveLead(l);
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "search_result";
	}
}
