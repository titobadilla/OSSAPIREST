package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Telephone")
public class Telephone implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "number")
	private String number;
	
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id")
	@JsonIgnore
	private Client client;

	public Telephone() {
		this.client=new Client();		
	}

	
	public Telephone(int id, String type, String number, Client client) {
		this.id = id;
		this.type = type;
		this.number = number;
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
		
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Telephone [id=" + id + ", type=" + type + ", number=" + number + "]";
	}

	
	
	
}
