package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Work_order_material")
public class WorkOrderMaterial implements Serializable{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WorkOrderMaterialId id;

    @Column(name = "quantity")
    private int quantity;

	public WorkOrderMaterial(WorkOrderMaterialId id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public WorkOrderMaterial() {
		this.id=new WorkOrderMaterialId();		
	}

	public WorkOrderMaterialId getId() {
		return id;
	}

	public void setId(WorkOrderMaterialId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "WorkOrderMaterial [id=" + id + ", quantity=" + quantity + "]";
	}
    
    
}
