package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SuppliesDeviceId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "kit_work_order_id")
    private KitWorkOrder kitWorkOrder ;

    @ManyToOne
    @JoinColumn(name = "id_device")
    private Device device;

    public SuppliesDeviceId() {
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
}
