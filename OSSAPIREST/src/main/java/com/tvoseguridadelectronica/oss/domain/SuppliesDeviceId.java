package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SuppliesDeviceId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "list_work_order_id")
    private KitWorkOrder listWorkOrder ;

    @ManyToOne
    @JoinColumn(name = "id_device")
    private Device device;

    public SuppliesDeviceId() {
    }

    public SuppliesDeviceId(KitWorkOrder kitWorkOrder, Device device) {
        this.listWorkOrder = kitWorkOrder;
        this.device = device;
    }

    public KitWorkOrder getListWorkOrder() {
        return listWorkOrder;
    }

    public void setListWorkOrder(KitWorkOrder kitWorkOrder) {
        this.listWorkOrder = kitWorkOrder;
    }

    public Device getDevice() {
        return device;
    }

    public void setDeviceId(Device device) {
        this.device = device;
    }
}
