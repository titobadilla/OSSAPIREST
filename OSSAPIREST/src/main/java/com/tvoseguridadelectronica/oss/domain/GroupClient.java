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
	
	@Column(name = "id_head_client")
	private String idHeadClient;
	
	@OneToMany(mappedBy = "group")
	private List<Client> clients;

	public GroupClient() {
		this.clients = new ArrayList<>();
	}

	public GroupClient(int idGroup, String idHeadClient, List<Client> clients) {
		this.idGroup = idGroup;
		this.idHeadClient = idHeadClient;
		this.clients = clients;
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public String getIdHeadClient() {
		return idHeadClient;
	}

	public void setIdHeadClient(String idHeadClient) {
		this.idHeadClient = idHeadClient;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "GroupClient [idGroup=" + idGroup + ", idHeadClient=" + idHeadClient + ", clients=" + clients + "]";
	}
	
	
}


