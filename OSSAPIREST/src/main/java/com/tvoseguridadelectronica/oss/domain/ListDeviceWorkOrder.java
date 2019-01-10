package com.tvoseguridadelectronica.oss.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order_device")
public class ListDeviceWorkOrder implements Serializable {

    @Autowired
    @EmbeddedId
    private ListDeviceWorkOrderId id;

    @ManyToOne
    @JoinColumn(name = "list_work_order_id")
    private ListWorkOrder listWorkOrder;

    @ManyToOne
    @JoinColumn(name = "id_device")
    private Device device;

    @Column(name = "quantity")
    private int quantity;

    public ListDeviceWorkOrder(ListWorkOrder listWorkOrder, Device device, int quantity) {
        this.listWorkOrder = listWorkOrder;
        this.device = device;
        this.quantity = quantity;
    }

    public ListDeviceWorkOrder() {
        this.listWorkOrder = new ListWorkOrder();
        this.device = new Device();
    }

    public ListWorkOrder getListWorkOrder() {
        return listWorkOrder;
    }

    public void setListWorkOrder(ListWorkOrder listWorkOrder) {
        this.listWorkOrder = listWorkOrder;
    }

    public Device getDevice() { return device; }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
