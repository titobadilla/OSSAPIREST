package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "District")
public class District implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	@EmbeddedId
	private DistrictId districtId;
	
	@Column(name = "name")
	private String name;

	public District(DistrictId districtId, String name) {
		this.districtId = districtId;
		this.name = name;
	}

	public District() {
		this.districtId=new DistrictId();
	}

	public DistrictId getDistrictId() {
		return districtId;
	}

	public void setDistrictId(DistrictId districtId) {
		this.districtId = districtId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "District [districtId=" + districtId + ", name=" + name + "]";
	}
	
			
	
	
}
