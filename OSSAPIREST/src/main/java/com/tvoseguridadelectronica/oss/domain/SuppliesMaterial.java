package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Supplies_material")
public class SuppliesMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SuppliesMaterialId id;

    @Column(name = "quantity")
    private float quantity;

    public SuppliesMaterial(float quantity) {
        this.quantity = quantity;
    }

    public SuppliesMaterial() {
        this.id = new SuppliesMaterialId();
    }

    public SuppliesMaterialId getId() {
        return id;
    }

    public void setId(SuppliesMaterialId id) {
        this.id = id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
