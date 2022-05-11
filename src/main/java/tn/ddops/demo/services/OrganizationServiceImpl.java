package tn.ddops.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ddops.demo.entities.Organization;
import tn.ddops.demo.enums.OrganizationName;
import tn.ddops.demo.repositories.OrganizationRepository;

@Service
public class OrganizationServiceImpl  implements IOrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;

	@Override
	public Organization addOrganization(Organization org) {
		// TODO Auto-generated method stub
		return organizationRepository.save(org);
	}

	@Override
	public List<Organization> getOrganizations() {
		// TODO Auto-generated method stub
		return organizationRepository.findAll();
	}
	
	@Override
	public Organization getOrganizationByName(OrganizationName org) {
		// TODO Auto-generated method stub
		return organizationRepository.findByNameOrganization(org);
	}
	


}
