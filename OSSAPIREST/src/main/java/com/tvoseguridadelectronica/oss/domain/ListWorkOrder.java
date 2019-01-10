package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "List_work_order")
public class ListWorkOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public ListWorkOrder(String name) {
        this.name = name;
    }

    public ListWorkOrder() {
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
