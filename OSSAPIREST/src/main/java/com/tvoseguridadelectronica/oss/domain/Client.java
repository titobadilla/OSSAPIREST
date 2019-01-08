package com.tvoseguridadelectronica.oss.domain;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Client")
public class Client {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Telephone> telephones;
	
	@OneToOne(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private AddressDescription addressDescription;
	
	@ManyToOne
	@JoinColumn(name = "group_client_id")
	@JsonManagedReference
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

	public Client(String id, String name, String contactName, List<Telephone> telephones,
			AddressDescription addressDescription, GroupClient group/*, List<WorkOrder> workOrders*/) {
		this.id = id;
		this.name = name;
		this.contactName = contactName;
		this.telephones = telephones;
		this.addressDescription = addressDescription;
		this.group = group;
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

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
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

/*	public List<WorkOrder> getWorkOrders() {
		return workOrders;
	}

	public void setWorkOrders(List<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}*/



	
	
}
