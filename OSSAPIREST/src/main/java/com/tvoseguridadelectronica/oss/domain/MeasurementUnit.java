package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Measurement_unit")
public class MeasurementUnit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public MeasurementUnit(String name) {
        this.name = name;
    }

    public MeasurementUnit() {
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

    @Override
    public String toString() {
        return "MeasurementUnit{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                '}';
    }
}
