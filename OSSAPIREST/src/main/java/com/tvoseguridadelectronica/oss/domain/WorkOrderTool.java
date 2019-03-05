package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Work_order_tool")
public class WorkOrderTool implements Serializable{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WorkOrderToolId id;

    @Column(name = "quantity")
    private int quantity;

	public WorkOrderTool(WorkOrderToolId id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public WorkOrderTool() {
		this.id=new WorkOrderToolId();
	}

	public WorkOrderToolId getId() {
		return id;
	}

	public void setId(WorkOrderToolId id) {
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
		return "WorkOrderTool [id=" + id + ", quantity=" + quantity + "]";
	}
    
    
}
