package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CantonId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="province_id",insertable=false,updatable=false)
	private Province province;

	public CantonId(String id, Province province) {
		this.id = id;
		this.province = province;
	}

	public CantonId() {
		this.province=new Province();	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "CantonId [id=" + id + ", province=" + province + "]";
	}
	
		

}
