package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class WorkOrderMaterialId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "work_order_id")
    private WorkOrder workOrder ;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

	public WorkOrderMaterialId(WorkOrder workOrder, Material material) {
		this.workOrder = workOrder;
		this.material = material;
	}

	public WorkOrderMaterialId() {
		this.workOrder=new WorkOrder();
		this.material=new Material();
	}

	public WorkOrder getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "WorkOrderMaterialId [workOrder=" + workOrder + ", material=" + material + "]";
	}
	
	
    
    
}
