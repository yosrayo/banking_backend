package tn.ddops.demo.entities;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.ddops.demo.enums.AccountType;
import tn.ddops.demo.enums.City;
import tn.ddops.demo.enums.Governorate;
import tn.ddops.demo.enums.WorkType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id_user")
	private long idUser;
	
	
	@JsonProperty("id_paiement")
	private double idPaiement;
	
	@JsonProperty("verified")
	private boolean verified=false;
	
	@JsonProperty("username")
	private String username;
	
	
	@JsonProperty("first_name")
	private String firstName;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@JsonProperty("birth_date")
	private Date birthDate;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("phone")
	private long phone;
	
	

	@JsonProperty("photo")
	private String photo;
	
	@JsonProperty("mail")
	private String mail;
	
	@JsonProperty("pwd")
	private String pwd;
	
	@JsonProperty("conf_code")
	private int confCode;
	
	@JsonProperty("solde")
	private double solde;
	
	@JsonProperty("bank")
	private String bank;
	
	@JsonProperty("governorate")
	private String governorate;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("work_type")
	private String workType;
	
	@JsonProperty("account_type")
	private String accountType;
	
	@OneToMany(mappedBy="userFrom")
	@JsonIgnore
	private Set<Action> actionsDone;
	
	@OneToMany(mappedBy="userTo")
	@JsonIgnore
	private Set<Action> actionsDoneOn;
	
	@OneToMany(mappedBy="userFrom")
	@JsonIgnore
	private Set<Facture> factures;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch
			= FetchType.EAGER)
			private Set<Role> roles;


	public long getIdUser() {
		return idUser;
	}


	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}


	public double getIdPaiement() {
		return idPaiement;
	}


	public void setIdPaiement(double idPaiement) {
		this.idPaiement = idPaiement;
	}


	public boolean isVerified() {
		return verified;
	}


	public void setVerified(boolean verified) {
		this.verified = verified;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public int getConfCode() {
		return confCode;
	}


	public void setConfCode(int confCode) {
		this.confCode = confCode;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	



	public Set<Action> getActionsDone() {
		return actionsDone;
	}


	public void setActionsDone(Set<Action> actionsDone) {
		this.actionsDone = actionsDone;
	}


	public Set<Action> getActionsDoneOn() {
		return actionsDoneOn;
	}


	public void setActionsDoneOn(Set<Action> actionsDoneOn) {
		this.actionsDoneOn = actionsDoneOn;
	}


	public Set<Facture> getFactures() {
		return factures;
	}


	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}


	public String getGovernorate() {
		return governorate;
	}


	public void setGovernorate(String governorate) {
		this.governorate = governorate;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getWorkType() {
		return workType;
	}


	public void setWorkType(String workType) {
		this.workType = workType;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	
}
