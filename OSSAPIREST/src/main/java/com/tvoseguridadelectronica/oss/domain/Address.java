package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "canton")
	private String canton;

	public Address() {
		
	}

	public Address(int id, String province, String district, String canton) {
		this.id = id;
		this.province = province;
		this.district = district;
		this.canton = canton;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", district=" + district + ", canton=" + canton + "]";
	}
	
	
	
}
