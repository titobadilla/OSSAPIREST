package com.tvoseguridadelectronica.oss.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order_device")
public class ListDeviceWorkOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ListDeviceWorkOrderId id;

    @Column(name = "quantity")
    private int quantity;

    public ListDeviceWorkOrder( int quantity) {
        this.quantity = quantity;
    }

    public ListDeviceWorkOrder() {
        this.id = new ListDeviceWorkOrderId();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public ListDeviceWorkOrderId getId() {
        return id;
    }

    public void setId(ListDeviceWorkOrderId id) {
        this.id = id;
    }
}
