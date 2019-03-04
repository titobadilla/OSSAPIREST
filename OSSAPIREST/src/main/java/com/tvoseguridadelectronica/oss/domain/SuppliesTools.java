package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Supplies_tool")
public class SuppliesTools implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SuppliesToolId id;

    @Column(name = "quantity")
    private int quantity;

    public SuppliesTools(int quantity) {
        this.quantity = quantity;
    }

    public SuppliesTools() {
        this.id = new SuppliesToolId();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SuppliesToolId getId() {
        return id;
    }

    public void setId(SuppliesToolId id) {
        this.id = id;
    }
}
