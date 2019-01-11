package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ListMaterialWorkOrderId implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private ListWorkOrder listWorkOrder;

    @ManyToOne
    private Material material;

    public ListMaterialWorkOrderId(ListWorkOrder listWorkOrder, Material material) {
        this.listWorkOrder = listWorkOrder;
        this.material = material;
    }

    public ListMaterialWorkOrderId() {
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

    @Override
    public String toString() {
        return "ListMaterialWorkOrderId{" +
                "listWorkOrder=" + listWorkOrder +
                ", material=" + material +
                '}';
    }
}
