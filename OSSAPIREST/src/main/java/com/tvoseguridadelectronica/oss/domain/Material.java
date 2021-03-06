package com.tvoseguridadelectronica.oss.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Material")
public class Material implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity", updatable= false)
    private float quantity;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "inventory_category_id")
    private InventoryCategory inventoryCategory;

    @ManyToOne
    @JoinColumn(name = "measurement_unit_id")
    private MeasurementUnit measurementUnit;

    public Material() {
    }

    public Material(String name, float quantity, String description, Model model, InventoryCategory inventoryCategory, MeasurementUnit measurementUnit) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.model = new Model();
        this.inventoryCategory = new InventoryCategory();
        this.measurementUnit = new MeasurementUnit();
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

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public InventoryCategory getInventoryCategory() {
        return inventoryCategory;
    }

    public void setInventoryCategory(InventoryCategory inventoryCategory) {
        this.inventoryCategory = inventoryCategory;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", quantity:" + quantity +
                ", description:'" + description + '\'' +
                ", model:" + model +
                ", inventoryCategory:" + inventoryCategory +
                ", measurementUnit:" + measurementUnit +
                '}';
    }
}
