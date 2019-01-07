package com.tvoseguridadelectronica.oss.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "position")
	private String position;
	
	@ManyToOne
	@JoinColumn(name = "employee_role_id")
	@JsonManagedReference
	private EmployeeRole role;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Telephone> telephones;

	public Employee() {
		this.role=new EmployeeRole();
		this.telephones=new ArrayList<>();
	}

	public Employee(String id, String name, String lastName, String position, EmployeeRole role,
			List<Telephone> telephones) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.position = position;
		this.role = role;
		this.telephones = telephones;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public EmployeeRole getRole() {
		return role;
	}

	public void setRole(EmployeeRole role) {
		this.role = role;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", lastName=" + lastName + ", position=" + position + ", role="
				+ role + ", telephones=" + telephones + "]";
	}
	
	
	
	
}
