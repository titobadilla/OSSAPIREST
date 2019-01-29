package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Color")
public class Color {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "color")
	private String color;
	
	private String state;

	public Color() {
		
	}
	
	public Color(int id, String color, String state) {
		this.id = id;
		this.color = color;
		this.state=state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Color [id=" + id + ", color=" + color + ", state=" + state + "]";
	}

	
}
