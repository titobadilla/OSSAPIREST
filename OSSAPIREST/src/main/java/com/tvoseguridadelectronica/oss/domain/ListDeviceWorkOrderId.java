package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ListDeviceWorkOrderId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "list_work_order_id")
    private ListWorkOrder listWorkOrder ;

    @ManyToOne
    @JoinColumn(name = "id_device")
    private Device device;

    public ListDeviceWorkOrderId() {
    }

    public ListDeviceWorkOrderId(ListWorkOrder listWorkOrder, Device device) {
        this.listWorkOrder = listWorkOrder;
        this.device = device;
    }

    public ListWorkOrder getListWorkOrder() {
        return listWorkOrder;
    }

    public void setListWorkOrder(ListWorkOrder listWorkOrder) {
        this.listWorkOrder = listWorkOrder;
    }

    public Device getDevice() {
        return device;
    }

    public void setDeviceId(Device device) {
        this.device = device;
    }
}
