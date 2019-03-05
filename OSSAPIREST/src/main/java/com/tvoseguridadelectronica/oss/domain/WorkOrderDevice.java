package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Work_order_device")
public class WorkOrderDevice implements Serializable{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WorkOrderDeviceId id;

    @Column(name = "quantity")
    private int quantity;

	public WorkOrderDevice(WorkOrderDeviceId id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public WorkOrderDevice() {
		this.id=new WorkOrderDeviceId();
	}

	public WorkOrderDeviceId getId() {
		return id;
	}

	public void setId(WorkOrderDeviceId id) {
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
		return "WorkOrderDevice [id=" + id + ", quantity=" + quantity + "]";
	}
    
    
}
