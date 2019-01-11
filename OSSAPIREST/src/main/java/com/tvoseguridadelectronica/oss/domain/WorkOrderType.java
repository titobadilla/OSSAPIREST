package com.tvoseguridadelectronica.oss.domain;

import java.io.Serializable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Work_order_type")
public class WorkOrderType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public WorkOrderType(String name) {
        this.name = name;
    }

    public WorkOrderType() {
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
