package tn.ddops.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.ddops.demo.entities.Organization;
import tn.ddops.demo.enums.OrganizationName;
import tn.ddops.demo.services.IOrganizationService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/organization")
public class OrganizationController {


	@Autowired
	IOrganizationService organizationService;

	@PostMapping("/addOrganization")
	@ResponseBody
	public Organization addOrganization(@RequestBody Organization org) {
		
		System.out.println("user added succesfully !");
		return organizationService.addOrganization(org);
	}
	
	@GetMapping("/findOrganizations")
	@ResponseBody
	public List<Organization> getOrganizations() {

		System.out.println("user found succesfully !");
		return organizationService.getOrganizations();
	}
	
	@GetMapping("/findOrganization/{orgName}")
	@ResponseBody
	public Organization getOrganizationByName(@PathVariable("orgName") OrganizationName orgName) {

		return organizationService.getOrganizationByName(orgName);
	}
	
}
