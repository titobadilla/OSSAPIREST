package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ListDeviceWorkOrderId implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private ListWorkOrder listWorkOrder;

    @ManyToOne
    private Device device;

    public ListDeviceWorkOrderId(ListWorkOrder listWorkOrder, Device device) {
        this.listWorkOrder = listWorkOrder;
        this.device = device;
    }

    public ListDeviceWorkOrderId() {
        this.listWorkOrder = new ListWorkOrder();
        this.device = new Device();
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

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "ListDeviceWorkOrderId{" +
                "listWorkOrder=" + listWorkOrder +
                ", device=" + device +
                '}';
    }
}
