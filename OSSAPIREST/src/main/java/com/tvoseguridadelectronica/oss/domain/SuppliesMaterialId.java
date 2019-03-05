package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SuppliesMaterialId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "kit_work_order_id")
    private KitWorkOrder kitWorkOrder ;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    public SuppliesMaterialId() {
    }

    public SuppliesMaterialId(KitWorkOrder kitWorkOrder, Material material) {
        this.kitWorkOrder = kitWorkOrder;
        this.material = material;
    }

    public KitWorkOrder getkitWorkOrder() {
        return kitWorkOrder;
    }

    public void setkitWorkOrder(KitWorkOrder kitWorkOrder) {
        this.kitWorkOrder = kitWorkOrder;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
