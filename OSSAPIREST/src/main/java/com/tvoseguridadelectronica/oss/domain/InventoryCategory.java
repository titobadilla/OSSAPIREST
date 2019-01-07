package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Inventory_category")

public class InventoryCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public InventoryCategory() {
    }

    public InventoryCategory(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
