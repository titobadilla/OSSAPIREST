package com.tvoseguridadelectronica.oss.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order_device")
public class ListToolWorkOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    @EmbeddedId
    private ListToolWorkOrderId id;

    @Column(name = "quantity")
    private int quantity;

    public ListToolWorkOrder(int quantity) {
        this.quantity = quantity;
    }

    public ListToolWorkOrder() {
        this.id = new ListToolWorkOrderId();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
