package com.tvoseguridadelectronica.oss.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order_material")
public class ListMaterialWorkOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ListMaterialWorkOrderId id;

    @Column(name = "quantity")
    private int quantity;

    public ListMaterialWorkOrder(int quantity) {
        this.quantity = quantity;
    }

    public ListMaterialWorkOrder() {
        this.id = new ListMaterialWorkOrderId();
    }

    public ListMaterialWorkOrderId getId() {
        return id;
    }

    public void setId(ListMaterialWorkOrderId id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
