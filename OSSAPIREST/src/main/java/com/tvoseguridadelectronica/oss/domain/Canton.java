package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Canton")
public class Canton implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	@EmbeddedId
	private CantonId cantonId;
	
	@Column(name = "name")
	private String name;

	public Canton(CantonId cantonId, String name) {
		this.cantonId = cantonId;
		this.name = name;
	}

	public Canton() {
		this.cantonId=new CantonId();
	}

	public CantonId getCantonId() {
		return cantonId;
	}

	public void setCantonId(CantonId cantonId) {
		this.cantonId = cantonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Canton [cantonId=" + cantonId + ", name=" + name + "]";
	}
	
	
	
	
	
	

}
