package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class WorkOrderDeviceId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    @JoinColumn(name = "work_order_id")
    private WorkOrder workOrder ;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

	public WorkOrderDeviceId(WorkOrder workOrder, Device device) {
		this.workOrder = workOrder;
		this.device = device;
	}

	public WorkOrderDeviceId() {
		this.workOrder=new WorkOrder();
		this.device=new Device();
	}

	public WorkOrder getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "WorkOrderDeviceId [workOrder=" + workOrder + ", device=" + device + "]";
	}
	
    
	
	
}
