package com.tvoseguridadelectronica.oss.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order_material")
public class ListMaterialWorkOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    @EmbeddedId
    private ListMaterialWorkOrderId id;

    @Column(name = "quantity")
    private int quantity;

    public ListMaterialWorkOrder( int quantity) {
        this.quantity = quantity;
    }

    public ListMaterialWorkOrder() {
        this.id = new ListMaterialWorkOrderId();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ListMaterialWorkOrder{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
