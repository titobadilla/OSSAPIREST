package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Kit_work_order")
public class KitWorkOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy="id.kitWorkOrder")
	private List<SuppliesDevice> listSuppliesDevices;
	
	@OneToMany(mappedBy="id.kitWorkOrder")
	private List<SuppliesMaterial> listSuppliesMaterials;
	
	@OneToMany(mappedBy="id.kitWorkOrder")
	private List<SuppliesTool> listSuppliesTools;

	public KitWorkOrder(int id, String name, List<SuppliesDevice> listSuppliesDevices,
			List<SuppliesMaterial> listSuppliesMaterials, List<SuppliesTool> listSuppliesTools) {
		this.id = id;
		this.name = name;
		this.listSuppliesDevices = listSuppliesDevices;
		this.listSuppliesMaterials = listSuppliesMaterials;
		this.listSuppliesTools = listSuppliesTools;
	}

	public KitWorkOrder() {
		this.listSuppliesDevices=new ArrayList<>();
		this.listSuppliesMaterials=new ArrayList<>();
		this.listSuppliesTools=new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SuppliesDevice> getListSuppliesDevices() {
		return listSuppliesDevices;
	}

	public void setListSuppliesDevices(List<SuppliesDevice> listSuppliesDevices) {
		this.listSuppliesDevices = listSuppliesDevices;
	}

	public List<SuppliesMaterial> getListSuppliesMaterials() {
		return listSuppliesMaterials;
	}

	public void setListSuppliesMaterials(List<SuppliesMaterial> listSuppliesMaterials) {
		this.listSuppliesMaterials = listSuppliesMaterials;
	}

	public List<SuppliesTool> getListSuppliesTools() {
		return listSuppliesTools;
	}

	public void setListSuppliesTools(List<SuppliesTool> listSuppliesTools) {
		this.listSuppliesTools = listSuppliesTools;
	}

	@Override
	public String toString() {
		return "KitWorkOrder [id=" + id + ", name=" + name + ", listSuppliesDevices=" + listSuppliesDevices
				+ ", listSuppliesMaterials=" + listSuppliesMaterials + ", listSuppliesTools=" + listSuppliesTools + "]";
	}

	
	
	

}
