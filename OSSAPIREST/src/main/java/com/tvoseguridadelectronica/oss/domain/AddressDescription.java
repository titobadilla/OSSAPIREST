package com.tvoseguridadelectronica.oss.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address_description")
public class AddressDescription implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumns(value = {@JoinColumn(name = "district_id", referencedColumnName="id"), 
           @JoinColumn(name= "canton_id", referencedColumnName="canton_id"),
           @JoinColumn(name= "province_id", referencedColumnName="province_id")})
    private District district;

	public AddressDescription(int id, String description, Province province, Canton canton, District district) {
		this.id = id;
		this.description = description;
		this.district = district;
	}

	public AddressDescription() {
		this.district=new District();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "AddressDescription [id=" + id + ", description=" + description + ", district=" + district + "]";
	}

	
	
}
