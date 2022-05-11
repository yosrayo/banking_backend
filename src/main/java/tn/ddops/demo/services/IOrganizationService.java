package tn.ddops.demo.services;

import java.util.List;

import tn.ddops.demo.entities.Organization;
import tn.ddops.demo.enums.OrganizationName;

public interface IOrganizationService {
	
	public Organization addOrganization(Organization org);
	
	public List<Organization> getOrganizations();

	public Organization getOrganizationByName(OrganizationName org);

}
