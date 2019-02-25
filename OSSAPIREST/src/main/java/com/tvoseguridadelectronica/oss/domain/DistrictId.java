package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class DistrictId implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Column(name = "id")
	private String id;
    
   	@ManyToOne
	@JoinColumns({@JoinColumn(name = "canton_id", referencedColumnName="id",insertable=false,updatable=false), 
        @JoinColumn(name= "province_id", referencedColumnName="province_id",insertable=false,updatable=false)})
	private Canton canton;

	public DistrictId(String id, Province province, Canton canton) {
		this.id = id;
		this.canton = canton;
	}

	public DistrictId() {
		this.canton=new Canton();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Canton getCanton() {
		return canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	@Override
	public String toString() {
		return "DistrictId [id=" + id + ", canton=" + canton + "]";
	}

	
	
	
	
	
	

}
