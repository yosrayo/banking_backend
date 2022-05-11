package tn.ddops.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Facture  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id_facture")
	private long idFacture;
	
	
	@JsonProperty("reference")
	@Column(length=25)
	private double reference;
	
	@JsonProperty("amount")
	private double amount;
	
	@JsonProperty("payed")
	private boolean payed;
	
	@ManyToOne
	@JsonProperty("user_from")
	private User userFrom;
	
	@ManyToOne
	@JsonProperty("organization_to")
	private Organization organizationTo;

	public long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}

	public double getReference() {
		return reference;
	}

	public void setReference(double reference) {
		this.reference = reference;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public User getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}

	public Organization getOrganizationTo() {
		return organizationTo;
	}

	public void setOrganizationTo(Organization organizationTo) {
		this.organizationTo = organizationTo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
