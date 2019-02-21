package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Client")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "contact_last_name")
	private String contactLastName;

	@OneToMany(mappedBy="client")
	@JsonManagedReference
	private List<TelephoneClient> telephones;
	
	@OneToOne
	@JoinColumn(name="address_description_id")
	//@JsonManagedReference
	private AddressDescription addressDescription;
	
	@ManyToOne
	@JoinColumn(name = "group_client_id")
	//@JsonBackReference
	private GroupClient group;
	
	/*@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )*/
	//private List<WorkOrder> workOrders;

	public Client() {
		this.telephones = new ArrayList<>();
		this.addressDescription = new AddressDescription();
		this.group = new GroupClient();
		//this.workOrders=new ArrayList<>();
	}

	public Client(String id, String name, String contactName, List<TelephoneClient> telephones,
			AddressDescription addressDescription, GroupClient group/*, List<WorkOrder> workOrders*/,String contactLastName) {
		this.id = id;
		this.name = name;
		this.contactName = contactName;
		this.telephones = telephones;
		this.addressDescription = addressDescription;
		this.group = group;
		this.contactLastName=contactLastName;
		//this.workOrders = workOrders;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	
	public List<TelephoneClient> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<TelephoneClient> telephones) {
		this.telephones = telephones;
	}
	
	public AddressDescription getAddressDescription() {
		return addressDescription;
	}

	public void setAddressDescription(AddressDescription addressDescription) {
		this.addressDescription = addressDescription;
	}

	public GroupClient getGroup() {
		return group;
	}

	public void setGroup(GroupClient group) {
		this.group = group;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", contactName=" + contactName + ", contactLastName="
				+ contactLastName + ", telephones=" + telephones + ", addressDescription=" + addressDescription
				+ ", group=" + group + "]";
	}


	
	

/*	public List<WorkOrder> getWorkOrders() {
		return workOrders;
	}

	public void setWorkOrders(List<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}*/



	
	
}
