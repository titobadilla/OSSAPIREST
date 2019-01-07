package com.tvoseguridadelectronica.oss.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Device_State")
public class DeviceState implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "state")
    private String state;

    public DeviceState(String state) {
        this.state = state;
    }

    public DeviceState() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DeviceState{" +
                "id:" + id +
                ", state:'" + state + '\'' +
                '}';
    }
}
