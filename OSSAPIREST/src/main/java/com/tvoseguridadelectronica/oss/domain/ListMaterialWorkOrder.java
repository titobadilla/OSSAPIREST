package com.tvoseguridadelectronica.oss.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order_material")
public class ListMaterialWorkOrder implements Serializable {

    @Autowired
    @EmbeddedId
    private ListMaterialWorkOrder id;

    @ManyToOne
    @JoinColumn(name = "list_work_order_id")
    private ListWorkOrder listWorkOrder;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    @Column(name = "quantity")
    private int quantity;

    public ListMaterialWorkOrder(ListWorkOrder listWorkOrder, Material material, int quantity) {
        this.listWorkOrder = listWorkOrder;
        this.material = material;
        this.quantity = quantity;
    }

    public ListMaterialWorkOrder() {
        this.listWorkOrder = new ListWorkOrder();
        this.material = new Material();
    }

    public ListWorkOrder getListWorkOrder() {
        return listWorkOrder;
    }

    public void setListWorkOrder(ListWorkOrder listWorkOrder) {
        this.listWorkOrder = listWorkOrder;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
