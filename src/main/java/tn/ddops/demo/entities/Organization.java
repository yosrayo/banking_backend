package tn.ddops.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.ddops.demo.enums.OrganizationName;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Organization  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOrganization;
	
	private String codeOrganization;
	
	@JsonProperty("solde")
	private double solde;
	
	@Enumerated(EnumType.STRING)
	private OrganizationName nameOrganization;
	
	@OneToMany(mappedBy="organizationTo")
	@JsonIgnore
	private Set<Facture> facture;

	public long getIdOrganization() {
		return idOrganization;
	}

	public void setIdOrganization(long idOrganization) {
		this.idOrganization = idOrganization;
	}

	public String getCodeOrganization() {
		return codeOrganization;
	}

	public void setCodeOrganization(String codeOrganization) {
		this.codeOrganization = codeOrganization;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public OrganizationName getNameOrganization() {
		return nameOrganization;
	}

	public void setNameOrganization(OrganizationName nameOrganization) {
		this.nameOrganization = nameOrganization;
	}

	public Set<Facture> getFacture() {
		return facture;
	}

	public void setFacture(Set<Facture> facture) {
		this.facture = facture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
