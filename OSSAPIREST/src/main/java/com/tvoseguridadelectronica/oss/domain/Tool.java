package com.tvoseguridadelectronica.oss.domain;


import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Tool")
public class Tool implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity", updatable= false)
    private int quantity;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "measurement_unit_id")
    private MeasurementUnit measurementUnit;

    @ManyToOne
    @JoinColumn(name = "inventory_category_id")
    private InventoryCategory inventoryCategory;

    public Tool() {
    }

    public Tool(String name, int quantity, String description, MeasurementUnit measurementUnit, InventoryCategory inventoryCategory) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.measurementUnit = new MeasurementUnit();
        this.inventoryCategory = new InventoryCategory();
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public InventoryCategory getInventoryCategory() {
        return inventoryCategory;
    }

    public void setInventoryCategory(InventoryCategory inventoryCategory) {
        this.inventoryCategory = inventoryCategory;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", quantity:" + quantity +
                ", description:'" + description + '\'' +
                ", measurementUnit:" + measurementUnit +
                ", inventoryCategory:" + inventoryCategory +
                '}';
    }
}
