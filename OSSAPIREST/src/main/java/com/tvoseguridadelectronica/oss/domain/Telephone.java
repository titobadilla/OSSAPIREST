package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Telephone")
public class Telephone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "number")
	private String number;

	public Telephone() {
		
	}

	public Telephone(int id, String type, String number) {
		this.id = id;
		this.type = type;
		this.number = number;
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

	@Override
	public String toString() {
		return "Telephone [id=" + id + ", type=" + type + ", number=" + number + "]";
	}
	
	
}
