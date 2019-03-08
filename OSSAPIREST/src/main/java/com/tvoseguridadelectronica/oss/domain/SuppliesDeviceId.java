package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@Embeddable
public class SuppliesDeviceId implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "kit_work_order_id")
	@JsonIgnoreProperties({"listSuppliesDevices","listSuppliesMaterials","listSuppliesTools"})
    private KitWorkOrder kitWorkOrder;

    @ManyToOne
    @JoinColumn(name = "id_device")
    private Device device;

    public SuppliesDeviceId() {
    	this.kitWorkOrder=new KitWorkOrder();
    	this.device=new Device();
    }

    public SuppliesDeviceId(KitWorkOrder kitWorkOrder, Device device) {
        this.kitWorkOrder = kitWorkOrder;
        this.device = device;
    }

    public KitWorkOrder getkitWorkOrder() {
        return kitWorkOrder;
    }

    public void setkitWorkOrder(KitWorkOrder kitWorkOrder) {
        this.kitWorkOrder = kitWorkOrder;
    }

    public Device getDevice() {
        return device;
    }

    public void setDeviceId(Device device) {
        this.device = device;
    }

	@Override
	public String toString() {
		return "SuppliesDeviceId [kitWorkOrder=" + kitWorkOrder + ", device=" + device + "]";
	}
    
}
