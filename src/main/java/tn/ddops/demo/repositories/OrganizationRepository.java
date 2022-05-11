package tn.ddops.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.ddops.demo.entities.Organization;
import tn.ddops.demo.enums.OrganizationName;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long>{
	
	public Organization findByNameOrganization(OrganizationName orgName);

}
