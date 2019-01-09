package com.tvoseguridadelectronica.oss.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Device")
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity", updatable= false)
    private int quantity;

    @Column(name = "manufacture_model")
    private String manufactureModel;

    @ManyToOne
    @JoinColumn(name = "model_id")
    @JsonManagedReference
    private Model model;

    @ManyToOne
    @JoinColumn(name = "inventory_category_id")
    @JsonManagedReference
    private InventoryCategory inventoryCategory;

    @ManyToOne
    @JoinColumn(name = "measurement_unit_id")
    @JsonManagedReference
    private MeasurementUnit measurementUnit;

    @ManyToOne
    @JoinColumn(name = "device_state_id")
    @JsonManagedReference
    private DeviceState deviceState;

    public Device(String serialNumber, String name, String description, int quantity, String manufactureModel, Model model, InventoryCategory inventoryCategory, MeasurementUnit measurementUnit, DeviceState deviceState) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.manufactureModel = manufactureModel;
        this.model = new Model();
        this.inventoryCategory = new InventoryCategory();
        this.measurementUnit = new MeasurementUnit();
        this.deviceState = new DeviceState();
    }

    public Device() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufactureModel() {
        return manufactureModel;
    }

    public void setManufactureModel(String manufactureModel) {
        this.manufactureModel = manufactureModel;
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

    public DeviceState getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(DeviceState deviceState) {
        this.deviceState = deviceState;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id:" + id +
                ", serialNumber:'" + serialNumber + '\'' +
                ", name:'" + name + '\'' +
                ", description:'" + description + '\'' +
                ", quantity:" + quantity +
                ", manufactureModel:'" + manufactureModel + '\'' +
                ", model:" + model +
                ", inventoryCategory:" + inventoryCategory +
                ", measurementUnit:" + measurementUnit +
                ", deviceState:" + deviceState +
                '}';
    }
}
