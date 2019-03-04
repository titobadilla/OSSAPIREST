package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SuppliesMaterialId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "list_work_order_id")
    private KitWorkOrder listWorkOrder ;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    public SuppliesMaterialId() {
    }

    public SuppliesMaterialId(KitWorkOrder kitWorkOrder, Material material) {
        this.listWorkOrder = kitWorkOrder;
        this.material = material;
    }

    public KitWorkOrder getListWorkOrder() {
        return listWorkOrder;
    }

    public void setListWorkOrder(KitWorkOrder kitWorkOrder) {
        this.listWorkOrder = kitWorkOrder;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
