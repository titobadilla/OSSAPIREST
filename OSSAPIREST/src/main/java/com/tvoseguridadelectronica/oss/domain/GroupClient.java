package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Group_client")
public class GroupClient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idGroup;
	
	@Column(name = "name_group")
	private String nameGroup;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "contact_last_name")
	private String contactLastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone1")
	private String phone1;
	
	@Column(name = "phone2")
	private String phone2;
	
	@OneToMany(mappedBy = "group")
	@JsonIgnoreProperties({ "group" })	
	private List<Client> clients;

	public GroupClient() {
		this.clients = new ArrayList<>();
	}

	public GroupClient(int idGroup, String nameGroup, String contactName, String contactLastName, String email,
			String phone1, String phone2, List<Client> clients) {
		this.idGroup = idGroup;
		this.nameGroup = nameGroup;
		this.contactName = contactName;
		this.contactLastName = contactLastName;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.clients = clients;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public String getNameGroup() {
		return nameGroup;
	}

	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "GroupClient [idGroup=" + idGroup + ", nameGroup=" + nameGroup + ", contactName=" + contactName
				+ ", contactLastName=" + contactLastName + ", email=" + email + ", phone1=" + phone1 + ", phone2="
				+ phone2 + ", clients=" + clients + "]";
	}


	
}


