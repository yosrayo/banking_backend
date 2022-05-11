package tn.ddops.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Action implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id_action")
	private long idAction;
	

	@JsonProperty("action_type")
	private String actionType;
	
	@JsonProperty("amount")
	private double amount;
	
	@Temporal(TemporalType.DATE)
	@JsonProperty("date_action")
	private Date dateAction = new Date();

	@JsonProperty("payed")
	private boolean payed;
	
	
	@JsonProperty("reference")
	@Column(length=25)
	private double reference;
	
	
	 
	@ManyToOne
	@JsonIgnore
	@JsonProperty("user_from")
	private User userFrom;
	
	@ManyToOne
	@JsonIgnore
	@JsonProperty("user_to")
	private User userTo;
	
	@ManyToOne
	@JsonIgnore
	@JsonProperty("organizationTo")
	private Organization organizationTo;

	public long getIdAction() {
		return idAction;
	}

	public void setIdAction(long idAction) {
		this.idAction = idAction;
	}



	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(Date dateAction) {
		this.dateAction = dateAction;
	}

	public User getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}

	public User getUserTo() {
		return userTo;
	}

	public void setUserTo(User userTo) {
		this.userTo = userTo;
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

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
	}

	public double getReference() {
		return reference;
	}

	public void setReference(double reference) {
		this.reference = reference;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	

}
