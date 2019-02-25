package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ListMaterialWorkOrderId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "list_work_order_id")
    private ListWorkOrder listWorkOrder ;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    public ListMaterialWorkOrderId() {
    }

    public ListMaterialWorkOrderId(ListWorkOrder listWorkOrder, Material material) {
        this.listWorkOrder = listWorkOrder;
        this.material = material;
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
}
